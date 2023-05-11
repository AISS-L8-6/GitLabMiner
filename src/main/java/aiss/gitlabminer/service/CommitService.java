package aiss.gitlabminer.service;

import aiss.gitlabminer.model.Commit;
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

@Service
public class CommitService {

    @Autowired
    RestTemplate restTemplate;

    // @Value("${githubminer.token}")
    private final String token = "glpat-kzszo-mUVCguU-yT-BNy";

    public List<Commit> findAllCommit(String projectId, Integer sinceCommits, Integer maxPages) throws HttpClientErrorException {

        String url = "https://gitlab.com/api/v4/projects/" + projectId + "/repository/commits?since=" + LocalDateTime.now().minusDays(sinceCommits) + "&" + "maxPages=" + maxPages;

        HttpHeaders headers = new HttpHeaders();
        if(token != "") {
            headers.set("Authorization", "Bearer " + token);
        }
        HttpEntity<Commit[]> request = new HttpEntity<>(null, headers);
        ResponseEntity<Commit[]> response = restTemplate
                .exchange(url, HttpMethod.GET, request, Commit[].class);

        List<Commit> result = new ArrayList<>();
        result.addAll(Arrays.asList(response.getBody()));

        return result;
    }
}
