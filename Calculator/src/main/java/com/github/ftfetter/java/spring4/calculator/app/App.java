package com.github.ftfetter.java.spring4.calculator.app;

import com.github.ftfetter.java.spring4.calculator.config.AppConfig;
import com.github.ftfetter.java.spring4.calculator.operations.Calculator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {

    public static void main(String[] args){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        Calculator useCalculator = (Calculator) applicationContext.getBean("calculator");

        useCalculator.calculate(1,2,"+");
        useCalculator.calculate(7,6,"*");
        useCalculator.calculate(4,8,"+");
        useCalculator.calculate(4,0,"/");
        useCalculator.calculate(7,3,"-");
        useCalculator.calculate(9,3,"/");
        useCalculator.calculate(5,7,"k");
        useCalculator.calculate(2,4,"^");
        System.out.println(useCalculator.printHistory());

        ((AnnotationConfigApplicationContext) applicationContext).close();
    }
}
