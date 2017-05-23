package com.github.ftfetter.java.spring4.calculator.operations;

import org.springframework.stereotype.Component;

@Component
public class Sub implements Operation {

    @Override
    public double calculate(double value1, double value2) {
        return value1-value2;
    }
}
