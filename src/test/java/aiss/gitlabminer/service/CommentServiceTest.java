package aiss.gitlabminer.service;

import aiss.gitlabminer.model.comment.Comment;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CommentServiceTest {

    @Autowired
    CommentService service;
    @Test
    @DisplayName("Get all comments")
    void findAllComment() {
        String projectId = "13083";
        String issueId = "21";
        List<Comment> comments = service.findAllComment(projectId, issueId);
        assertTrue(!comments.isEmpty(), "list of comment is empty");
        for(Comment c:comments){
            System.out.println(c);
        }
    }
}