package nl.ordina.springboot;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class TimeRestController {

    @RequestMapping("/time")
    public String getTime() {
        String greeting = null;
        return greeting + "\n"  + " It is now: "  + new Date();

    }

    @RequestMapping("/timeandweather")
    public String getTimeAndWeather() {
        String weather = null;
        return getTime() + weather;
    }

}
