package aiss.gitlabminer.utils;

import org.springframework.http.HttpHeaders;

import java.util.List;

public class Utils {

    public static String getNextPageUrl(HttpHeaders headers){
        String nextPageUrl = null;
        if(headers.get("Link") == null){
            return null;
        }
        List<String> linkHeader = headers.get("Link");
        if(linkHeader.get(0) == null || linkHeader.get(0).isEmpty()){
            return null;
        }
        for(String token: linkHeader.get(0).split(", ")){
            if(token.endsWith("rel=\"next\"")){
                int idx = token.indexOf('>');
                nextPageUrl = token.substring(1, idx);
                break;
            }
        }
        return nextPageUrl;
    }
}
