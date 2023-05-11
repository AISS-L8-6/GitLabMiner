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
        String projectId = "13083";
        Integer sinceIssue = 2;
        Integer maxPages = 2;
        List<Issue> issues = service.findAllIssue(projectId, sinceIssue, maxPages);
        assertTrue(!issues.isEmpty(), "list of issue is empty");
        for(Issue i:issues){
            System.out.println(i);
        }
    }
}