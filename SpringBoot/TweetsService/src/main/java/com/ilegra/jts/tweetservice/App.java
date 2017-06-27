package com.ilegra.jts.tweetservice;

import com.ilegra.jts.app.module.service.ControllerService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages = "service")
public class App {

    public static void main(String[] args) throws Exception{
        SpringApplication.run(ControllerService.class, args);
    }
}
