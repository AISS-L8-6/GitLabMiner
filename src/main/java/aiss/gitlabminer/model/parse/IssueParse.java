package aiss.gitlabminer.model.parse;

import aiss.gitlabminer.model.issue.Issue;

import java.util.List;

public class IssueParse {

    private String id;
    private String refId;
    private String title;
    private String description;
    private String state;
    private String createdAt;
    private String updated_at;
    private String closed_at;
    private List<String> labels;
    private UserParse author;
    private UserParse assignee;
    private Integer upvotes;
    private Integer downvotes;
    private String webUrl;
    private List<CommentParse> comments;

    public IssueParse(String id, String refId, String title, String description, String state, String createdAt, String updatedAt, String closedAt, List<String> labels, UserParse author, UserParse assignee, Integer upvotes, Integer downvotes, String webUrl, List<CommentParse> comments) {
        this.id = id;
        this.refId = refId;
        this.title = title;
        this.description = description;
        this.state = state;
        this.createdAt = createdAt;
        this.updated_at = updatedAt;
        this.closed_at = closedAt;
        this.labels = labels;
        this.author = author;
        this.assignee = assignee;
        this.upvotes = upvotes;
        this.downvotes = downvotes;
        this.webUrl = webUrl;
        this.comments = comments;
    }

    public IssueParse(Issue issue, UserParse author, UserParse assignee, List<CommentParse> comments) {
        this.id = issue.getId();
        this.refId = issue.getIid();
        this.title = issue.getTitle();
        this.description = issue.getDescription();
        this.state = issue.getState();
        this.createdAt = issue.getCreatedAt();
        this.updated_at = issue.getUpdatedAt();
        this.closed_at = issue.getClosedAt();
        this.labels = issue.getLabels();
        this.author = author;
        this.assignee = assignee;
        this.upvotes = issue.getUpvotes();
        this.downvotes = issue.getDownvotes();
        this.webUrl = issue.getWeb_url();
        this.comments = comments;
    }

    public IssueParse(){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRefId() {
        return refId;
    }

    public void setRefId(String refId) {
        this.refId = refId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updated_at;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updated_at = updatedAt;
    }

    public String getClosedAt() {
        return closed_at;
    }

    public void setClosedAt(String closedAt) {
        this.closed_at = closedAt;
    }

    public List<String> getLabels() {
        return labels;
    }

    public void setLabels(List<String> labels) {
        this.labels = labels;
    }

    public UserParse getAuthor() {
        return author;
    }

    public void setAuthor(UserParse author) {
        this.author = author;
    }

    public UserParse getAssignee() {
        return assignee;
    }

    public void setAssignee(UserParse assignee) {
        this.assignee = assignee;
    }

    public Integer getUpvotes() {
        return upvotes;
    }

    public void setUpvotes(Integer upvotes) {
        this.upvotes = upvotes;
    }

    public Integer getDownvotes() {
        return downvotes;
    }

    public void setDownvotes(Integer downvotes) {
        this.downvotes = downvotes;
    }

    public String getWebUrl() {
        return webUrl;
    }

    public void setWebUrl(String webUrl) {
        this.webUrl = webUrl;
    }

    public List<CommentParse> getComments() {
        return comments;
    }

    public void setComments(List<CommentParse> comments) {
        this.comments = comments;
    }
}
