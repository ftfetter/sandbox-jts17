package com.ilegra.jts.tweetservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

@RestController
@EnableAutoConfiguration
@ComponentScan
@RequestMapping(value = "/tweets")
public class ControllerService {

    @Autowired
    TweetService tweetService;

    @RequestMapping(value = "/username/{user}")
    @ResponseBody
    public String numberOfTweets(@PathVariable(value = "user") String username) {

        int numTweets = tweetService.getTweets(username);
        String message = "User @"+ username +" not found";
        if(numTweets >= 0) {
            message = "Num of tweets from @" + username + ": " + numTweets;
        }
        return message;
    }
}
