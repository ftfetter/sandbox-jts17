package cxf.rest.vehicles;

import cxf.spring.AppConfig;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class CarResourceTest {

    @Autowired
    CarResource carResource;

    @Test
    public void printTaxTest(){
        Assert.assertEquals("U$ 2.11", carResource.printTax());
    }

    @Test
    public void insufficientPayTaxTest(){
        Assert.assertEquals("Insufficient money. U$ -0.96", carResource.payTax(1.15));
    }

    @Test
    public void okPayTax(){
        Assert.assertEquals("Up to pass. You must repay U$ 2.89", carResource.payTax(5d));
    }
}
