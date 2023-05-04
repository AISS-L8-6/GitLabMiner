package aiss.gitlabminer.service;

import aiss.gitlabminer.model.Commit;
import aiss.gitlabminer.model.Project;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CommitServiceTest {

    @Autowired
    CommitService service;

    @Test
    @DisplayName("Get all commits")
    void findAllCommits() {
        String projectId = "45577899";
        Integer sinceCommits = 2;
        Integer maxPages = 2;
        List<Commit> commits = service.findAllCommit(projectId, sinceCommits, maxPages);
        assertTrue(!commits.isEmpty(), "list of commits is empty");
        for(Commit c:commits){
            System.out.println(c);
        }
    }
}