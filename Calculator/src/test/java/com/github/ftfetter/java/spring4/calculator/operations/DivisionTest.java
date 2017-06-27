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
public class DivisionTest {

    @Autowired
    private Division division;

    @Test
    public void divisionTest(){
        Assert.assertEquals("10.0 / 5.0 = 2.0",division.calculate(10,5));
    }
}
