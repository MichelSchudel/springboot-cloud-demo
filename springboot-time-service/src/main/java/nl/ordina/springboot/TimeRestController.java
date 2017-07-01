package nl.ordina.springboot;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@RestController
public class TimeRestController {

    @Value("${app.greeting}")
    private String timeGreeting;

    @LoadBalanced
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private TrageServiceClient trageServiceClient;

    @RequestMapping("/time")
    public String getTime() {
        String trageGreeting = trageServiceClient.getTraag();
        String greeting = restTemplate.getForObject("http://greeting-service/greeting", String.class);
        return greeting + "\n"  + timeGreeting + new Date() + trageGreeting;
    }

}
