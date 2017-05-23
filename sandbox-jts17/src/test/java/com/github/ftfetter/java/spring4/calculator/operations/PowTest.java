package com.github.ftfetter.java.spring4.calculator.operations;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class PowTest {

    @Autowired
    private Pow pow;

    @Test
    public void powTest(){

        Assert.assertEquals(16,pow.calculate(4,2),0);
    }
}
