package aiss.gitlabminer.service;

import aiss.gitlabminer.model.issue.Issue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class IssueService {

    @Autowired
    RestTemplate restTemplate;


    // @Value("${githubminer.token}")
    private final String token = "glpat-kzszo-mUVCguU-yT-BNy";

    private final LocalDateTime sinceIssue = LocalDateTime.now().minusDays(2);
    private final String maxPages = "2";

    public List<Issue> findAllIssue(String projectId, Integer sinceIssue, Integer maxPages) throws HttpClientErrorException {

        String url = "https://gitlab.com/api/v4/projects/" + projectId + "/issues";

        if(sinceIssue.equals(null)) {
            url.concat("?since=" + this.sinceIssue + "&");
        }else {
            url.concat("?since=" + LocalDateTime.now().minusDays(sinceIssue) + "&");
        }
        if(maxPages.equals(null)) {
            url.concat("?maxPages=" + this.maxPages);
        }else {
            url.concat("?maxPages=" + maxPages);
        }

        HttpHeaders headers = new HttpHeaders();
        if(token != "") {
            headers.set("Authorization", "Bearer " + token);
        }
        HttpEntity<Issue[]> request = new HttpEntity<>(null, headers);
        ResponseEntity<Issue[]> response = restTemplate
                .exchange(url, HttpMethod.GET, request, Issue[].class);

        List<Issue> result = new ArrayList<>();
        result.addAll(Arrays.asList(response.getBody()));

        return result;
    }
/*
    public Issue getIssueById(String issueIid) throws HttpClientErrorException{

        HttpHeaders headers = new HttpHeaders();
        if(token != "") {
            headers.set("Authorization", "Bearer " + token);
        }
        HttpEntity<Issue> request = new HttpEntity<>(null, headers);
        ResponseEntity<Issue> response = restTemplate
                .exchange("https://gitlab.com/api/v4/issues/" + issueIid, HttpMethod.GET, request, Issue.class);
        return response.getBody();
    }

    public Issue getIssueByIdAndProject(String projectId, String issueId)  throws HttpClientErrorException{
        HttpHeaders headers = new HttpHeaders();
        if(token != "") {
            headers.set("Authorization", "Bearer " + token);
        }
        HttpEntity<Issue> request = new HttpEntity<>(null, headers);
        ResponseEntity<Issue> response = restTemplate
                .exchange("https://gitlab.com/api/v4/projects/" + projectId + "/issues/" + issueId, HttpMethod.GET, request, Issue.class);
        return response.getBody();
    }

    public List<Issue> getIssueByProjectAndState(String projectId, String state)  throws HttpClientErrorException{
        HttpHeaders headers = new HttpHeaders();
        if(token != "") {
            headers.set("Authorization", "Bearer " + token);
        }
        HttpEntity<Issue[]> request = new HttpEntity<>(null, headers);
        ResponseEntity<Issue[]> response = restTemplate
                .exchange("https://gitlab.com/api/v4/projects/" + projectId + "/issues", HttpMethod.GET, request, Issue[].class);

        List<Issue> result = new ArrayList<>();
        result.addAll(Arrays.asList(response.getBody()));

        return result.stream().filter(i -> i.getState().equals(state)).collect(Collectors.toList());
    }

 */

}