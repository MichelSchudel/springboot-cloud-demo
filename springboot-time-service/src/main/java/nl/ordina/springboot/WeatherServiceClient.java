package nl.ordina.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@Service
public class WeatherServiceClient {

    @Autowired
    @LoadBalanced
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "fallback", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000")
            ,@HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "5000")

    })
    public String getTraag() {
        String traag = restTemplate.getForObject("http://weather-service/weather", String.class);
        return traag;
    }

    public String fallback() {
        return "...don't know actually...";
    }
}
