package aiss.gitlabminer.service;

import aiss.gitlabminer.model.Comment;
import aiss.gitlabminer.model.Project;
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
        String projectId = "278964";
        String issueId = "409214";
        List<Comment> comments = service.findAllComment(projectId, issueId);
        assertTrue(!comments.isEmpty(), "list of comment is empty");
        for(Comment c:comments){
            System.out.println(c);
        }
    }

    @Test
    void getCommentById() {
        String projectId = "278964";
        String issueId = "409214";
        String commentId = "1373167959";
        Comment comment = service.getCommentById(projectId, issueId, commentId);
        assertTrue(!comment.equals(null), "project is empty");
        System.out.println(comment);
    }
}