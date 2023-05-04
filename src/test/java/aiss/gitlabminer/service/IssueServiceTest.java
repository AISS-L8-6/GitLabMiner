package aiss.gitlabminer.service;

import aiss.gitlabminer.model.issue.Issue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class IssueServiceTest {

    @Autowired
    IssueService service;

    @Test
    @DisplayName("Get all issue")
    void findAllIssue() {
        String projectId = "278964";
        Integer sinceIssue = 2;
        Integer maxPages = 2;
        List<Issue> issues = service.findAllIssue(projectId, sinceIssue, maxPages);
        assertTrue(!issues.isEmpty(), "list of issue is empty");
        for(Issue i:issues){
            System.out.println(i);
        }
    }

    @Test
    @DisplayName("Find one issue")
    void getProjectById() {
        String issueIid = "41"; //Es necesario el id_ref o iid y no el id de la issue
        Issue issue = service.getIssueById(issueIid);
        assertTrue(!issue.equals(null), "issue is empty");
        System.out.println(issue);
    }

    @Test
    @DisplayName("Find one issue in a project")
    void getProjectByIdAndProject() {
        String projectId = "20699";
        String issueId = "1";
        Issue issue = service.getIssueByIdAndProject(projectId, issueId);
        assertTrue(!issue.equals(null), "issue is empty");
        System.out.println(issue);
    }

    @Test
    @DisplayName("Find issues by state and project")
    void getIssueByProjectAndState() {
        String projectId = "20699";
        String state = "closed";
        List<Issue> issues = service.getIssueByProjectAndState(projectId, state);
        assertTrue(!issues.isEmpty(), "list of issue is empty");
        for(Issue i:issues){
            System.out.println(i);
        }
    }
}