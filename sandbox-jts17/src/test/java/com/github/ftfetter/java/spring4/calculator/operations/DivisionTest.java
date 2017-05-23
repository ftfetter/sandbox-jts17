package com.github.ftfetter.java.spring4.calculator.operations;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class DivisionTest {

    @Autowired
    private Division division;

    @Test
    public void divisionTest(){

        Assert.assertEquals(2,division.calculate(10,2),0);
    }
}
