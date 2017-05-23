package com.github.ftfetter.java.spring4.calculator.operations;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class SubTest {

    @Autowired
    private Sub sub;

    @Test
    public void subTest(){
        Assert.assertEquals(2,sub.calculate(8,6),0);
    }
}
