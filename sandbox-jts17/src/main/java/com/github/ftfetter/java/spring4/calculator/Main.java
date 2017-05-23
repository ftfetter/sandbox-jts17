package com.github.ftfetter.java.spring4.calculator;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "com.github.ftfetter.java.spring4.calculator")
public class Main {

    public static void main(String[] args){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Main.class);

        Calculator useCalculator = (Calculator) applicationContext.getBean("calculator");

        useCalculator.calculate(1,3,0);
        useCalculator.calculate(7,6,2);
        useCalculator.calculate(2,7,1);
        useCalculator.calculate(5,0,3);
        useCalculator.calculate(4,2,4);
        useCalculator.calculate(2,3,5);
        useCalculator.printHistory();

        ((AnnotationConfigApplicationContext) applicationContext).close();
    }
}
