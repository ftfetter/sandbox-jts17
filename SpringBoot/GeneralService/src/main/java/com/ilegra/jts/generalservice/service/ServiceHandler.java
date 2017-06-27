package com.ilegra.jts.generalservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class ServiceHandler {

    @Autowired
    RestTemplate restTemplate;

    public Object federateTweetsService(String user) {
        ResponseEntity responseEntity = restTemplate.getForEntity("http://localhost:8081/tweets/username/"+user,
                String.class);
        return responseEntity.getBody();
    }

    public Object federateRepositoriesService(String user) {
        ResponseEntity responseEntity = restTemplate.getForEntity("http://localhost:8082/repositories/username/"+user,
                String.class);
        return responseEntity.getBody();

    }
}
