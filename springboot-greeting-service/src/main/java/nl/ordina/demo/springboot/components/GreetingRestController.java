package nl.ordina.demo.springboot.components;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingRestController {

    @Value("${server.port}")
    private String port;

    @RequestMapping("/greeting")
    public String echo() {
        return "Greetings from port " + port + "!";
    }


}
