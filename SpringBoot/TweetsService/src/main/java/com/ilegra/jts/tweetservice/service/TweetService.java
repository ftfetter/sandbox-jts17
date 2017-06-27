package com.ilegra.jts.tweetservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.twitter.api.Twitter;

public class TweetService {

    @Autowired
    Twitter twitter;

    public int getTweets(String username) {
        int numTweets = -1;
        try {
            numTweets = twitter.userOperations().getUserProfile(username).getStatusesCount();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return numTweets;
    }
}
