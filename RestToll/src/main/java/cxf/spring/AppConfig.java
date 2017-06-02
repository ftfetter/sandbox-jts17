package cxf.spring;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import cxf.rest.TollResource;
import cxf.rest.vehicles.BicycleResource;
import cxf.rest.vehicles.BusResource;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import javax.ws.rs.ext.RuntimeDelegate;
import java.util.Arrays;

@Configuration
public class AppConfig {

    @Bean(destroyMethod = "shutdown")
    public SpringBus cxf(){
        return new SpringBus();
    }

    @Bean
    @DependsOn("cxf")
    public Server jaxRsServer(){
        final JAXRSServerFactoryBean factory = RuntimeDelegate.getInstance().createEndpoint(tollRestService(),JAXRSServerFactoryBean.class);
        factory.setServiceBeans(Arrays.asList(tollRestService()));
        factory.setProviders(Arrays.asList(jsonProvider()));
        return factory.create();
    }

    @Bean
    public JacksonJsonProvider jsonProvider(){
        return new JacksonJsonProvider();
    }

    @Bean
    public TollResource tollRestService(){
        return new TollResource(bicycleRestService(), busRestService());
    }

    @Bean
    public BusResource busRestService(){
        return new BusResource();
    }

    @Bean
    public BicycleResource bicycleRestService(){
        return new BicycleResource();
    }
}
