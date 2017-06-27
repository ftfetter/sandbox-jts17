package com.ilegra.jts.generalservice;

import com.ilegra.jts.generalservice.service.ControllerService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "service")
public class App {

    public static void main(String[] args){
        SpringApplication.run(ControllerService.class);
    }
}
