package generalservice.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.web.client.RestTemplate;

import static org.mockito.Mockito.mock;

@Profile("test")
@Configuration
public class TestConfig {

    @Bean
    public ServiceHandler serviceHandler(){
        return mock(ServiceHandler.class);
    }

    @Bean
    public ControllerService controllerService(){
        return new ControllerService();
    }

    @Bean
    public RestTemplate restTemplate(){
        return mock(RestTemplate.class);
    }
}
