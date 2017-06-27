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
public class SumTest {

    @Autowired
    private Sum sum;

    @Test
    public void sumTest(){
        Assert.assertEquals("8.0 + 4.0 = 12.0",sum.calculate(8,4));
    }
}
