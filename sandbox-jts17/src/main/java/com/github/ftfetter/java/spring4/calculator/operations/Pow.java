package com.github.ftfetter.java.spring4.calculator.operations;

import org.springframework.stereotype.Component;

import static java.lang.Math.pow;

@Component
public class Pow implements Operation{

    @Override
    public double calculate(double value1, double value2) {
        return pow(value1,value2);
    }
}
