package com.github.ftfetter.java.spring4.calculator.operations;

import org.springframework.stereotype.Component;

import static java.lang.Math.*;

@Component
public class Pow implements Operations {

    @Override
    public String calculate(double value1, double value2) throws ArithmeticException{
        try {
            double result = pow(value1,value2);
            return value1 +" ^ "+ value2 +" = "+ result;
        } catch (Exception e) {
            return value1 +" ^ "+ value2 +" ERROR: An error has occured";
        }
    }
}
