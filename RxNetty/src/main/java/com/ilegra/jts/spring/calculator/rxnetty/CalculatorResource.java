package com.ilegra.jts.spring.calculator.rxnetty;

import com.ilegra.jts.spring.calculator.operations.Calculator;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/calculator")
public class CalculatorResource {

    Calculator calculator;

    @Autowired
    public CalculatorResource(Calculator calculator){
        this.calculator = calculator;
    }

    @GET
    @Produces
    public String history(){
        calculator.calculate(1,2,"+");
        calculator.calculate(7,6,"*");
        calculator.calculate(4,8,"+");
        calculator.calculate(4,0,"/");
        calculator.calculate(7,3,"-");
        calculator.calculate(9,3,"/");
        calculator.calculate(5,7,"k");
        calculator.calculate(2,4,"^");
        return calculator.printHistory();
    }
}
