package com.ilegra.jts.spring.calculator.operations;

import org.springframework.stereotype.Component;

@Component
public class Sum implements Operations {

    @Override
    public String calculate (double value1, double value2) {
        try {
            double result = value1+value2;
            return value1 +" + "+ value2 +" = "+ result;
        } catch (Exception e) {
            return value1 +" + "+ value2 +" ERROR: An error has occured";
        }
    }
}