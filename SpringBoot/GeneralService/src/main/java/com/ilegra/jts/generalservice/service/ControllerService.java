package com.ilegra.jts.generalservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
@ComponentScan
@RequestMapping("/tweetRepoApp")
public class ControllerService {

    @Autowired
    ServiceHandler serviceHandler;

    @RequestMapping("/tweets/{user}")
    @ResponseBody
    public String getTweets(@PathVariable("user") String username) {
        String message = "Tweets service is down";
        try {
            message = serviceHandler.federateTweetsService(username).toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return message;
    }

    @RequestMapping("/repos/{user}")
    @ResponseBody
    public String getRepos(@PathVariable("user") String username) {
        String message = "GitHub Repositories service is down";
        try {
            message = serviceHandler.federateRepositoriesService(username).toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return message;
    }

    @RequestMapping("/repos/{user1}/tweets/{user2}")
    @ResponseBody
    public String getReposAndTweets(@PathVariable("user1") String gitUser,
                                    @PathVariable("user2") String twitterUser) {
        return getTweets(twitterUser)+ "<br />" +getRepos(gitUser);
    }
}
