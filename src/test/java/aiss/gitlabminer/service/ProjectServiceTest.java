package aiss.gitlabminer.service;

import aiss.gitlabminer.model.Project;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProjectServiceTest {

    @Autowired
    ProjectService service;

    @Test
    @DisplayName("Get project by id")
    void getProjectById() {
        String id = "13083";
        Project project = service.getProjectById(id);
        assertTrue(!project.equals(null), "project is empty");
        System.out.println(project);
    }
}