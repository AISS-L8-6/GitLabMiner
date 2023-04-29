package aiss.gitlabminer.service;

import aiss.gitlabminer.model.Project;
import aiss.gitlabminer.model.User;
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
public class UserService {

    @Autowired
    RestTemplate restTemplate;

    // @Value("${githubminer.baseuri}")
    private String url=  "https://gitlab.com/api/v4";

    // @Value("${githubminer.token}")
    private String token = "glpat-kzszo-mUVCguU-yT-BNy";

    /*public List<Project> findAllProjects() throws HttpClientErrorException {

        HttpHeaders headers = new HttpHeaders();
        if(token != "") {
            headers.set("Authorization", "Bearer " + token);
        }
        HttpEntity<Project[]> request = new HttpEntity<>(null, headers);
        ResponseEntity<Project[]> response = restTemplate
                .exchange(url, HttpMethod.GET, request, Project[].class);

        List<Project> result = new ArrayList<>();
        result.addAll(Arrays.asList(response.getBody()));

        return result;
    }*/

    public List<User> getUsersByProjectId(String id) throws HttpClientErrorException{

        HttpHeaders headers = new HttpHeaders();
        if(token != "") {
            headers.set("Authorization", "Bearer " + token);
        }
        HttpEntity<User> request = new HttpEntity<>(null, headers);
        ResponseEntity<User> response = restTemplate
                .exchange(url+"/projects/"+id+"/users", HttpMethod.GET, request, User.class);
        List<User> result = new ArrayList<>();
        result.addAll(Arrays.asList(response.getBody()));

        return result;
    }
}
