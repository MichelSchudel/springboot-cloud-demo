package nl.ordina.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class TrageService {

    public static void main(String[] args) {
        SpringApplication.run(TrageService.class, args);
    }

}
