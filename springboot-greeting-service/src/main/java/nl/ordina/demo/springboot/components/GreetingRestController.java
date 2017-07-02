package nl.ordina.demo.springboot.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingRestController {

    @Value("${app.greeting}")
    private String greeting;

    @Autowired
    Environment environment;

    @RequestMapping("/greeting")
    public String echo() {
        String port = environment.getProperty("local.server.port");
        return greeting + " Greetings from port " + port + "!";
    }


}
