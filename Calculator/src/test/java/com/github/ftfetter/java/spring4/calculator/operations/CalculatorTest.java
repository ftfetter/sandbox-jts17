package com.github.ftfetter.java.spring4.calculator.operations;

import com.github.ftfetter.java.spring4.calculator.config.AppConfig;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class CalculatorTest {

    @Autowired
    private Calculator calculator;

    @Test
    public void testCalculateSum(){
        Assert.assertEquals("9.0 + 9.0 = 18.0",calculator.calculate(9,9,"+"));
    }
    @Test
    public void testCalculateSub(){
        Assert.assertEquals("9.0 - 4.0 = 5.0",calculator.calculate(9,4,"-"));
    }
    @Test
    public void testCalculateMultiply(){
        Assert.assertEquals("7.0 * 6.0 = 42.0",calculator.calculate(7,6,"*"));
    }
    @Test
    public void testCalculateDivision(){
        Assert.assertEquals("10.0 / 5.0 = 2.0",calculator.calculate(10,5,"/"));
    }
    @Test
    public void testCalculateDivisionByZero(){
        Assert.assertEquals("10.0 / 0.0 ERROR: Division by Zero",calculator.calculate(10,0,"/"));
    }
    @Test
    public void testCalculatePow(){
        Assert.assertEquals("4.0 ^ 2.0 = 16.0",calculator.calculate(4,2,"^"));
    }
}
