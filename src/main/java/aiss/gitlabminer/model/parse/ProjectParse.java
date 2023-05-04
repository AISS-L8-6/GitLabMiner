package aiss.gitlabminer.model.parse;

import aiss.gitlabminer.model.Commit;
import aiss.gitlabminer.model.issue.Issue;
import aiss.gitlabminer.model.Project;

import java.util.List;

public class ProjectParse {
    private String id;
    private String name;
    private String web_url;
    private List<Commit> commits;
    private List<IssueParse> issues;

    public ProjectParse(String id, String name, String web_url, List<Commit> commits, List<IssueParse> issues) {
        this.id = id;
        this.name = name;
        this.web_url = web_url;
        this.commits = commits;
        this.issues = issues;
    }

    public ProjectParse(Project project, List<Commit> commits, List<IssueParse> issues) {
        this.id = project.getId();
        this.name = project.getName();
        this.web_url = project.getWebUrl();
        this.commits = commits;
        this.issues = issues;
    }

    public ProjectParse() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWeb_url() {
        return web_url;
    }

    public void setWeb_url(String web_url) {
        this.web_url = web_url;
    }

    public List<Commit> getCommits() {
        return commits;
    }

    public void setCommits(List<Commit> commits) {
        this.commits = commits;
    }

    public List<IssueParse> getIssues() {
        return issues;
    }

    public void setIssues(List<IssueParse> issues) {
        this.issues = issues;
    }
}
