package com.bnpparibas.lafabrique.TPAlimentation.infrastructure.external;

import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Service
public class ChuckNorrisJokes implements IChuckNorrisJokes {

    RestTemplate restTemplate = new RestTemplate();

    final String ressourceURL = "https://api.chucknorris.io/jokes/random";

    @Override
    public String getALittleJoke() {

        // This one doesn't work, as user-agent is mandatory and this one doesn't have headers -> 403 forbidden
        //ChuckNorrisResponse chuckNorrisResponse = restTemplate.getForObject(ressourceURL, ChuckNorrisResponse.class);
        //return chuckNorrisResponse.getValue();

        HttpHeaders headers = new HttpHeaders();
        headers.add("user-agent", "toto");
        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

        ResponseEntity<ChuckNorrisResponse> response = restTemplate.exchange(ressourceURL, HttpMethod.GET, entity, ChuckNorrisResponse.class);

        return response.getBody().getValue();

    }

}
