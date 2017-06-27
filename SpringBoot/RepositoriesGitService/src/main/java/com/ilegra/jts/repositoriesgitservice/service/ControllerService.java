package com.ilegra.jts.repositoriesgitservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ComponentScan
@EnableAutoConfiguration
@RequestMapping("/repositories")
public class ControllerService {

    @Autowired
    RepositoriesService repositoriesService;

    @RequestMapping("/username/{user}")
    @ResponseBody
    public String numberOfRepositories(@PathVariable(value="user") String username) {
        int numRepositories = repositoriesService.getRepositories(username);
        String message = "User "+ username +" not found on GitHub";
        if (numRepositories>=0) {
            message = "The user "+ username +" has "+ numRepositories +" public repositories on GitHub";
        }
        return message;
    }
}
