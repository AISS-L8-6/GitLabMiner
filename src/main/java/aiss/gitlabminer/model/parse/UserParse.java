package aiss.gitlabminer.model.parse;

import aiss.gitlabminer.model.issue.Assignee__1;
import aiss.gitlabminer.model.issue.Author;

public class UserParse {
    private String id;
    private String username;
    private String name;
    private String avatar_url;
    private String web_url;

    public UserParse(String id, String username, String name, String avatar_url, String web_url) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.avatar_url = avatar_url;
        this.web_url = web_url;
    }

    public UserParse(Assignee__1 user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.name = user.getName();
        this.avatar_url = user.getAvatarUrl();
        this.web_url = user.getWebUrl();
    }

    public UserParse(Author user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.name = user.getName();
        this.avatar_url = user.getAvatarUrl();
        this.web_url = user.getWebUrl();
    }

    public UserParse(aiss.gitlabminer.model.comment.Author author) {
        this.id = author.getId();
        this.username = author.getUsername();
        this.name = author.getName();
        this.avatar_url = author.getAvatarUrl();
        this.web_url = author.getWebUrl();
    }
}
