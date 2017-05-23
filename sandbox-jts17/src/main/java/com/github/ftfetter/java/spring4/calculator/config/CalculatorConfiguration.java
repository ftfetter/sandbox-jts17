package com.github.ftfetter.java.spring4.calculator.config;

import com.github.ftfetter.java.spring4.calculator.Calculator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CalculatorConfiguration {

    @Bean
    public Calculator calculator() {
        Calculator cs = new Calculator();
        return cs;
    }
}
