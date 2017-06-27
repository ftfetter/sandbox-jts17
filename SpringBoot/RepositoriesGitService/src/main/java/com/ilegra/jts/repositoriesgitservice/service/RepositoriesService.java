package com.ilegra.jts.repositoriesgitservice.service;

import org.kohsuke.github.GitHub;
import org.springframework.beans.factory.annotation.Autowired;

public class RepositoriesService {

    @Autowired
    GitHub gitHub;

    public int getRepositories(String username) {
        int numRepo = -1;
        try {
            numRepo = gitHub.getUser(username).getRepositories().size();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return numRepo;
    }
}
