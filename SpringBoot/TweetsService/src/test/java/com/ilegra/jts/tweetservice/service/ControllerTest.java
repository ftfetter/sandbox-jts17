package com.ilegra.jts.tweetservice.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfig.class)
public class ControllerTest {

    @Autowired
    private ControllerService controllerService;

    @Autowired
    private TweetService tweetService;

    @Test
    public void messageTest() {
        when(tweetService.getTweets("marvin")).thenReturn(42);
        String message = controllerService.numberOfTweets("marvin");
        Assert.assertEquals("Num of tweets from @marvin: 42", message);
        verify(tweetService, atLeastOnce()).getTweets("marvin");
    }

    @Test
    public void errorMessageTest() {
        when(tweetService.getTweets("xablau")).thenReturn(-1);
        String message = controllerService.numberOfTweets("xablau");
        Assert.assertEquals("User @xablau not found", message);
        verify(tweetService, atLeastOnce()).getTweets("xablau");
    }
}
