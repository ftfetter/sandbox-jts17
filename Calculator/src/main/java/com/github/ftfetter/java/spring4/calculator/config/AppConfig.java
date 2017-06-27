package com.github.ftfetter.java.spring4.calculator.config;

import com.github.ftfetter.java.spring4.calculator.maps.MapHistory;
import com.github.ftfetter.java.spring4.calculator.maps.MapOperations;
import com.github.ftfetter.java.spring4.calculator.operations.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;

@Configuration
@ComponentScan(basePackages = "com.github.ftfetter.java.spring4.calculator.operations")
public class AppConfig {

    @Bean
    public MapOperations mapOperations(){
        MapOperations mapOperations = new MapOperations();
        mapOperations.getMapOperations().put("+", new Sum());
        mapOperations.getMapOperations().put("-", new Sub());
        mapOperations.getMapOperations().put("*", new Multiply());
        mapOperations.getMapOperations().put("/", new Division());
        mapOperations.getMapOperations().put("^", new Pow());
        return mapOperations;
    }
    @Bean
    public MapHistory mapHistory(){
        MapHistory mapHistory = new MapHistory();
        mapHistory.getMapHistory().put("+", new ArrayList<>());
        mapHistory.getMapHistory().put("-", new ArrayList<>());
        mapHistory.getMapHistory().put("*", new ArrayList<>());
        mapHistory.getMapHistory().put("/", new ArrayList<>());
        mapHistory.getMapHistory().put("^", new ArrayList<>());
        mapHistory.getMapHistory().put("error", new ArrayList<>());
        return mapHistory;
    }
    @Bean
    public Calculator calculator() {
        Calculator calculator = new Calculator(mapOperations(), mapHistory());
        return calculator;
    }
}
