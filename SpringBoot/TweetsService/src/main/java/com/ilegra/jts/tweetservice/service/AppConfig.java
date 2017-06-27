package com.ilegra.jts.tweetservice.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.social.twitter.api.impl.TwitterTemplate;

@Configuration
public class AppConfig {

    @Bean
    public TweetService tweetService() {
        return new TweetService();
    }

    @Bean
    public Twitter twitter() {
        return new TwitterTemplate(System.getenv("CONSUMER_KEY"),System.getenv("CONSUMER_SECRET"),
                System.getenv("TOKEN_ACCESS"),System.getenv("TOKEN_SECRET"));
    }

}
