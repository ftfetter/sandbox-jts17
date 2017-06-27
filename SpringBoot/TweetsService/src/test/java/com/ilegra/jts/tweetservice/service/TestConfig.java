package com.ilegra.jts.tweetservice.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.social.twitter.api.Twitter;

import static org.mockito.Mockito.mock;

@Profile("test")
@Configuration
public class TestConfig {

    @Bean
    @Primary
    public TweetService tweetService() {
        return mock(TweetService.class);
    }

    @Bean
    public Twitter twitter() {
        return mock(Twitter.class);
    }

    @Bean
    public ControllerService controllerService() {
        return new ControllerService();
    }
}
