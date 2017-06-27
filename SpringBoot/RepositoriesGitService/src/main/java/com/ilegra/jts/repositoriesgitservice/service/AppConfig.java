package com.ilegra.jts.repositoriesgitservice.service;

import org.kohsuke.github.GitHub;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
public class AppConfig {

    @Bean
    public RepositoriesService repositoriesService() {
        return new RepositoriesService();
    }

    @Bean
    public GitHub gitHub() throws IOException {
        return GitHub.connectUsingPassword(
                System.getenv("GIT_LOGIN"), System.getenv("GIT_PSSWRD"));
    }
}
