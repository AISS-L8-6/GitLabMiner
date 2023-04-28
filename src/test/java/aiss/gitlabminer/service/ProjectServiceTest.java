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
    @DisplayName("set all projects")
    void findAllProjects() {
//        ResponseEntity<Project[]> projects = service.findAllProjects();
//        assertTrue(!projects.equals(Project[]), "list of projects is empty");
//        for(Project p:projects){
//            System.out.println(p);
//        }
//        System.out.println(projects);
    }
}