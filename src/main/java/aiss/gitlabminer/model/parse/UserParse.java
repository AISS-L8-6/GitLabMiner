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

    public UserParse(){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }

    public String getWeb_url() {
        return web_url;
    }

    public void setWeb_url(String web_url) {
        this.web_url = web_url;
    }
}
