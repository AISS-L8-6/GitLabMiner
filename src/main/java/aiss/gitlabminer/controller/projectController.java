package aiss.gitlabminer.controller;

import aiss.gitlabminer.model.Commit;
import aiss.gitlabminer.model.comment.Comment;
import aiss.gitlabminer.model.issue.Issue;
import aiss.gitlabminer.model.Project;
import aiss.gitlabminer.model.parse.CommentParse;
import aiss.gitlabminer.model.parse.IssueParse;
import aiss.gitlabminer.model.parse.ProjectParse;
import aiss.gitlabminer.model.parse.UserParse;
import aiss.gitlabminer.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
public class projectController {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    CommentService commentService;

    @Autowired
    CommitService commitService;

    @Autowired
    IssueService issueService;

    @Autowired
    ProjectService projectService;

    @Autowired
    UserService userService;


    @PostMapping("gitLabMiner/project/{id}")
    public ProjectParse post(@PathVariable String id, @RequestParam(name = "sinceCommits") Integer sinceCommits, @RequestParam(name = "sinceIssues") Integer sinceIssues, @RequestParam(name = "maxPages") Integer maxPages){
        ProjectParse result;
        List<IssueParse> issueParses = new ArrayList<>();

        Project project = projectService.getProjectById(id);
        List<Issue> issueList = issueService.findAllIssue(id, sinceIssues, maxPages);
        List<Commit> commitList = commitService.findAllCommit(id, sinceCommits, maxPages);

        for(int i = 0; i < issueList.size(); i++){
            UserParse author = new UserParse(issueList.get(i).getAuthor());
            UserParse assignee = new UserParse(issueList.get(i).getAssignee());
            List<Comment> commentList = commentService.findAllComment(id, issueList.get(i).getId());
            List<CommentParse> commentParses = new ArrayList<>();
            for(int j = 0; j < commentList.size(); j++){
                UserParse commentAuthor = new UserParse(commentList.get(j).getAuthor());
                CommentParse commentParse = new CommentParse(commentList.get(j), commentAuthor);
                commentParses.add(commentParse);
            }
            IssueParse issueParse = new IssueParse(issueList.get(i), author, assignee, commentParses);
            issueParses.add(issueParse);
        }

        result = new ProjectParse(project.getId(), project.getName(), project.getWebUrl(), commitList, issueParses);

        return restTemplate.postForObject("http://localhost:8080/GitMiner/Projects", result, ProjectParse.class);
    }


}
