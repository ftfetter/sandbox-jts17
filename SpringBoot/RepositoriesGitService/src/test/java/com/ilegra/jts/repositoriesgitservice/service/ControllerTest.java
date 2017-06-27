package com.ilegra.jts.repositoriesgitservice.service;

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
    private RepositoriesService repositoriesService;

    @Test
    public void messageTest() {
        when(repositoriesService.getRepositories("marvin")).thenReturn(42);
        String message = controllerService.numberOfRepositories("marvin");
        Assert.assertEquals("The user marvin has 42 public repositories on GitHub", message);
        verify(repositoriesService, atLeastOnce()).getRepositories("marvin");
    }

    @Test
    public void errorMessageTest() {
        when(repositoriesService.getRepositories("xablau")).thenReturn(-1);
        String message = controllerService.numberOfRepositories("xablau");
        Assert.assertEquals("User xablau not found on GitHub", message);
        verify(repositoriesService, atLeastOnce()).getRepositories("xablau");
    }
}
