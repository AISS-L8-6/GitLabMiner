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
    @DisplayName("Get all projects")
    void findAllProjects() {
        List<Project> projects = service.findAllProjects();
        assertTrue(!projects.isEmpty(), "list of projects is empty");
        for(Project p:projects){
            System.out.println(p);
        }
    }

    @Test
    @DisplayName("Get project by id")
    void getProjectById() {
        String id = "45577899";
        Project project = service.getProjectById(id);
        assertTrue(!project.equals(null), "project is empty");
        System.out.println(project);
    }
}