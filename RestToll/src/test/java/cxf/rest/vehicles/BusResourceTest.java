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
public class BusResourceTest {

    @Autowired
    private BusResource busResource;

    @Test
    public void printTaxTest(){
        Assert.assertEquals("U$ 1.59", busResource.printTax());
    }

    @Test
    public void insufficientPayTaxTest(){
        Assert.assertEquals("Insufficient money. U$ -1.29", busResource.payTax(0.3));
    }

    @Test
    public void okPayTax(){
        Assert.assertEquals("Up to pass. You must repay U$ 1.41", busResource.payTax(3d));
    }
}
