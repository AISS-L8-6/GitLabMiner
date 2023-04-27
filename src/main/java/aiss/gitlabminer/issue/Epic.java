
package aiss.gitlabminer.issue;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "iid",
    "title",
    "url",
    "group_id",
    "human_readable_end_date",
    "human_readable_timestamp"
})
@Generated("jsonschema2pojo")
public class Epic {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("iid")
    private Integer iid;
    @JsonProperty("title")
    private String title;
    @JsonProperty("url")
    private String url;
    @JsonProperty("group_id")
    private Integer groupId;
    @JsonProperty("human_readable_end_date")
    private String humanReadableEndDate;
    @JsonProperty("human_readable_timestamp")
    private String humanReadableTimestamp;

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("iid")
    public Integer getIid() {
        return iid;
    }

    @JsonProperty("iid")
    public void setIid(Integer iid) {
        this.iid = iid;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    @JsonProperty("group_id")
    public Integer getGroupId() {
        return groupId;
    }

    @JsonProperty("group_id")
    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    @JsonProperty("human_readable_end_date")
    public String getHumanReadableEndDate() {
        return humanReadableEndDate;
    }

    @JsonProperty("human_readable_end_date")
    public void setHumanReadableEndDate(String humanReadableEndDate) {
        this.humanReadableEndDate = humanReadableEndDate;
    }

    @JsonProperty("human_readable_timestamp")
    public String getHumanReadableTimestamp() {
        return humanReadableTimestamp;
    }

    @JsonProperty("human_readable_timestamp")
    public void setHumanReadableTimestamp(String humanReadableTimestamp) {
        this.humanReadableTimestamp = humanReadableTimestamp;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Epic.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("id");
        sb.append('=');
        sb.append(((this.id == null)?"<null>":this.id));
        sb.append(',');
        sb.append("iid");
        sb.append('=');
        sb.append(((this.iid == null)?"<null>":this.iid));
        sb.append(',');
        sb.append("title");
        sb.append('=');
        sb.append(((this.title == null)?"<null>":this.title));
        sb.append(',');
        sb.append("url");
        sb.append('=');
        sb.append(((this.url == null)?"<null>":this.url));
        sb.append(',');
        sb.append("groupId");
        sb.append('=');
        sb.append(((this.groupId == null)?"<null>":this.groupId));
        sb.append(',');
        sb.append("humanReadableEndDate");
        sb.append('=');
        sb.append(((this.humanReadableEndDate == null)?"<null>":this.humanReadableEndDate));
        sb.append(',');
        sb.append("humanReadableTimestamp");
        sb.append('=');
        sb.append(((this.humanReadableTimestamp == null)?"<null>":this.humanReadableTimestamp));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
