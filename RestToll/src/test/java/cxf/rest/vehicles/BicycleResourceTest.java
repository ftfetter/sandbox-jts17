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
public class BicycleResourceTest {

    @Autowired
    private BicycleResource bicycleResource;

    @Test
    public void printTaxTest(){
        Assert.assertEquals("U$ 0.45", bicycleResource.printTax());
    }

    @Test
    public void insufficientPayTaxTest(){
        Assert.assertEquals("Insufficient money. U$ -0.2", bicycleResource.payTax(0.25));
    }

    @Test
    public void okPayTax(){
        Assert.assertEquals("Up to pass. You must repay U$ 0.55", bicycleResource.payTax(1d));
    }
}