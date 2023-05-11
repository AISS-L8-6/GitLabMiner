package aiss.gitlabminer.model.parse;

import aiss.gitlabminer.model.comment.Comment;

public class CommentParse {
    private String id;
    private String body;
    private UserParse author;
    private String created_at;
    private String updated_at;

    public CommentParse(){}

    public CommentParse(String id, String body, UserParse author, String created_at, String updated_at) {
        this.id = id;
        this.body = body;
        this.author = author;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public CommentParse(Comment comment, UserParse author) {
        this.id = comment.getId();
        this.body = comment.getBody();
        this.author = author;
        this.created_at = comment.getCreatedAt();
        this.updated_at = comment.getUpdatedAt();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public UserParse getAuthor() {
        return author;
    }

    public void setAuthor(UserParse author) {
        this.author = author;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }
}
