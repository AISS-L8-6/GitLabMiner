package aiss.gitlabminer.service;

import aiss.gitlabminer.model.issue.Issue;
import aiss.gitlabminer.utils.Utils;
import jdk.jshell.execution.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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


    @Value("${token}")
    private String token;

    public List<Issue> findAllIssue(String projectId, Integer sinceIssue, Integer maxPages) throws HttpClientErrorException {

        String url = "https://gitlab.com/api/v4/projects/" + projectId + "/issues?since=" + LocalDateTime.now().minusDays(sinceIssue) + "&" + "page=" + 1;

        HttpHeaders headers = new HttpHeaders();
        if(token != "") {
            headers.set("Authorization", "Bearer " + token);
        }
        HttpEntity<Issue[]> request = new HttpEntity<>(null, headers);
        ResponseEntity<Issue[]> response = restTemplate
                .exchange(url, HttpMethod.GET, request, Issue[].class);
        List<Issue> result = new ArrayList<>();
        result.addAll(Arrays.asList(response.getBody()));

        String nextPageUrl = Utils.getNextPageUrl(response.getHeaders());
        for(int i = 0; i <= maxPages && nextPageUrl != null; i++){
            response = restTemplate.exchange(nextPageUrl, HttpMethod.GET, request, Issue[].class);
            result.addAll(Arrays.asList(response.getBody()));
            nextPageUrl = Utils.getNextPageUrl(response.getHeaders());
        }
        return result;
    }

}