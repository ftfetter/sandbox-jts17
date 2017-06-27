package com.ilegra.jts.repositoriesgitservice.service;

import org.kohsuke.github.GitHub;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

import static org.mockito.Mockito.mock;

@Profile("test")
@Configuration
public class TestConfig {

    @Bean
    @Primary
    public RepositoriesService repositoriesService() {
        return mock(RepositoriesService.class);
    }

    @Bean
    public ControllerService controllerService() { return new ControllerService(); }

    @Bean
    public GitHub gitHub() { return mock(GitHub.class); }
}
