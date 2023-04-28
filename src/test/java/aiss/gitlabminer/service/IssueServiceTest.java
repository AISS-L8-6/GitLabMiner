package aiss.gitlabminer.service;

import aiss.gitlabminer.model.Issue;
import aiss.gitlabminer.model.Project;
import org.hamcrest.core.Is;
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
        List<Issue> issues = service.findAllIssue();
        assertTrue(!issues.isEmpty(), "list of issue is empty");
        for(Issue i:issues){
            System.out.println(i);
        }
    }

    @Test
    @DisplayName("Find one issue")
    void getProjectById() {
        String id = "45577899";
        Issue issue = service.getIssueById(id);
        assertTrue(!issue.equals(null), "issue is empty");
        System.out.println(issue);
    }
}