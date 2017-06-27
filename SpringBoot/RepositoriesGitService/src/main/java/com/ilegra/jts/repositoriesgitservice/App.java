package com.ilegra.jts.repositoriesgitservice;

import com.ilegra.jts.repositoriesgitservice.service.ControllerService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "service")
public class App {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(ControllerService.class);
    }
}
