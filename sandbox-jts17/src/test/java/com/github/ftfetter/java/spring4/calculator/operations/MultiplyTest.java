package com.github.ftfetter.java.spring4.calculator.operations;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class MultiplyTest {

    @Autowired
    private Multiply multiply;

    @Test
    public void multiplyTest(){
            Assert.assertEquals(10,multiply.calculate(5,2),0);
    }
}
