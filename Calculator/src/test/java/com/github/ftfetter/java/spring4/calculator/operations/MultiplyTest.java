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
public class MultiplyTest {

    @Autowired
    private Multiply multiply;

    @Test
    public void multiplyTest(){
        Assert.assertEquals("7.0 * 6.0 = 42.0",multiply.calculate(7,6));
    }
}
