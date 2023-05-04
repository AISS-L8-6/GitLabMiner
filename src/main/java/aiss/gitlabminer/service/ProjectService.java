package aiss.gitlabminer.service;

import aiss.gitlabminer.model.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ProjectService {

    @Autowired
    RestTemplate restTemplate;

    // @Value("${githubminer.baseuri}")
    private String url=  "https://gitlab.com/api/v4/projects";

    // @Value("${githubminer.token}")
    private String token = "glpat-kzszo-mUVCguU-yT-BNy";

    public Project getProjectById(String id) throws HttpClientErrorException{

        HttpHeaders headers = new HttpHeaders();
        if(token != "") {
            headers.set("Authorization", "Bearer " + token);
        }
        HttpEntity<Project> request = new HttpEntity<>(null, headers);
        ResponseEntity<Project> response = restTemplate
                .exchange(url+"/"+id, HttpMethod.GET, request, Project.class);
        return response.getBody();
    }
}
