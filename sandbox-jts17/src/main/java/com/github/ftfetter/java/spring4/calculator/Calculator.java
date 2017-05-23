package com.github.ftfetter.java.spring4.calculator;

import com.github.ftfetter.java.spring4.calculator.operations.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

    @Autowired
    private Sum sum;
    @Autowired
    private Sub sub;
    @Autowired
    private Multiply multiply;
    @Autowired
    private Division division;
    @Autowired
    private Pow pow;

    private List<String> history;

    public Calculator(){
        history = new ArrayList<>();
    }

    public double calculate(double value1, double value2, int op){

        double result = 0d;

        switch (op){
            case 0:
                result = sum.calculate(value1,value2);
                history.add(value1 +" + "+ value2 +" = "+ result);
                break;
            case 1:
                result = sub.calculate(value1,value2);
                history.add(value1 +" - "+ value2 +" = "+ result);
                break;
            case 2:
                result = multiply.calculate(value1,value2);
                history.add(value1 +" * "+ value2 +" = "+ result);
                break;
            case 3:
                if(value2 == 0)
                    history.add(value1 +" / "+ value2 +" **ERROR: Division by zero**");
                else {
                    result = division.calculate(value1, value2);
                    history.add(value1 +" / "+ value2 +" = "+ result);
                }
                break;
            case 4:
                result = pow.calculate(value1,value2);
                history.add(value1 +" ^ "+ value2 +" = "+ result);
                break;
            default:
                history.add("**ERROR: Invalid operation**");
        }

        return result;
    }

    public void printHistory(){
        for(int i = 0; i< history.size(); i++){
            System.out.println(history.get(i));
        }
    }

}
