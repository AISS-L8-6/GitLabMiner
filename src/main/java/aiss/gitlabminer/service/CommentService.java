package aiss.gitlabminer.service;

import aiss.gitlabminer.model.comment.Comment;
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
public class CommentService {

    @Autowired
    RestTemplate restTemplate;

    // @Value("${githubminer.token}")
    private final String token = "glpat-kzszo-mUVCguU-yT-BNy";

    public List<Comment> findAllComment(String projectId, String issueId) throws HttpClientErrorException {

        HttpHeaders headers = new HttpHeaders();
        if(token != "") {
            headers.set("Authorization", "Bearer " + token);
        }
        HttpEntity<Comment[]> request = new HttpEntity<>(null, headers);
        ResponseEntity<Comment[]> response = restTemplate
                .exchange("https://gitlab.com/api/v4/projects/" + projectId + "/issues/" + issueId + "/notes", HttpMethod.GET, request, Comment[].class);

        List<Comment> result = new ArrayList<>();
        result.addAll(Arrays.asList(response.getBody()));

        return result;
    }

}

