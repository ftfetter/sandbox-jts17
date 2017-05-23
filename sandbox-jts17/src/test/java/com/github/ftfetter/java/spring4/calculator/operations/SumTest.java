package com.github.ftfetter.java.spring4.calculator.operations;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class SumTest {

    @Autowired
    private Sum sum;

    @Test
    public void sumTest(){
        Assert.assertEquals(10,sum.calculate(3,7),0);
    }
}
