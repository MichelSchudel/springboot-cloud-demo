package nl.ordina.springboot;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TrageServiceController {

    @RequestMapping("/traag")
    public String traag() throws InterruptedException {
        double randomFraction = Math.random();
        Thread.sleep((long)(2000+ randomFraction * 5000));
        return "toch nog antwoord!";
    }
}
