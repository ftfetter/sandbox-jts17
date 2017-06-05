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
public class TruckResourceTest {

    @Autowired
    TruckResource truckResource;

    @Test
    public void printNoExtraAxisTruckTaxTest(){
        Assert.assertEquals("U$ 3.95", truckResource.printTax(0));
    }

    @Test
    public void printExtraAxisTruckTaxTest(){
        Assert.assertEquals("U$ 5.95", truckResource.printTax(2));
    }

    @Test
    public void insufficientPayTaxTest(){
        Assert.assertEquals("Insufficient money. U$ -2.95", truckResource.payTax(2,3d));
    }

    @Test
    public void okPayTax(){
        Assert.assertEquals("Up to pass. You must repay U$ 2.05", truckResource.payTax(0,6d));
    }
}
