package generalservice.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.mockito.Mockito.when;

@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfig.class)
public class ControllerTest {

    @Autowired
    private ControllerService controllerService;

    @Autowired
    private ServiceHandler serviceHandler;

    @Test
    public void tweetsResponseOKTest(){
        when(serviceHandler.federateTweetsService("xablau")).thenReturn("Tweets service OK");
        String response = controllerService.getTweets("xablau");
        Assert.assertEquals("Tweets service OK", response);
    }

    @Test
    public void tweetsResponseFailTest(){
        when(serviceHandler.federateTweetsService("xablau")).thenReturn(null);
        String response = controllerService.getTweets("xablau");
        Assert.assertEquals("Tweets service is down", response);
    }

    @Test
    public void reposResponseOKTest(){
        when(serviceHandler.federateRepositoriesService("xablau")).thenReturn("Repos service OK");
        String response = controllerService.getRepos("xablau");
        Assert.assertEquals("Repos service OK", response);
    }

    @Test
    public void reposResponseFailTest(){
        when(serviceHandler.federateRepositoriesService("xablau")).thenReturn(null);
        String response = controllerService.getRepos("xablau");
        Assert.assertEquals("GitHub Repositories service is down", response);
    }

    @Test
    public void tweetsAndReposResponseOKTest(){
        when(serviceHandler.federateTweetsService("xablau")).thenReturn("Tweets service OK");
        when(serviceHandler.federateRepositoriesService("xablau")).thenReturn("Repos service OK");
        String response = controllerService.getTweets("xablau")+" "+controllerService.getRepos("xablau");
        Assert.assertEquals("Tweets service OK Repos service OK", response);
    }

    @Test
    public void tweetsAndReposResponseFailTest(){
        when(serviceHandler.federateTweetsService("xablau")).thenReturn(null);
        when(serviceHandler.federateRepositoriesService("xablau")).thenReturn(null);
        String response = controllerService.getTweets("xablau")+" "+controllerService.getRepos("xablau");
        Assert.assertEquals("Tweets service is down GitHub Repositories service is down", response);
    }

    @Test
    public void tweetsOKReposFailTest(){
        when(serviceHandler.federateTweetsService("xablau")).thenReturn("Tweets service OK");
        when(serviceHandler.federateRepositoriesService("xablau")).thenReturn(null);
        String response = controllerService.getTweets("xablau")+" "+controllerService.getRepos("xablau");
        Assert.assertEquals("Tweets service OK GitHub Repositories service is down", response);
    }

    @Test
    public void tweetsFailReposOKTest(){
        when(serviceHandler.federateTweetsService("xablau")).thenReturn(null);
        when(serviceHandler.federateRepositoriesService("xablau")).thenReturn("Repos service OK");
        String response = controllerService.getTweets("xablau")+" "+controllerService.getRepos("xablau");
        Assert.assertEquals("Tweets service is down Repos service OK", response);
    }
}
