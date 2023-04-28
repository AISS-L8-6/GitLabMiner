package aiss.gitlabminer.service;

import aiss.gitlabminer.model.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class ProjectService {

    @Autowired
    RestTemplate restTemplate;

    public List<Project> findAllProjects(){
        String uri = "https://gitlab.com/api/v4/projects";
        Project[] projects = restTemplate.getForObject(uri, Project[].class);
        return Arrays.stream(projects).toList();
    }
}
