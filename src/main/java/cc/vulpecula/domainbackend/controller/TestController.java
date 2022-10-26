package cc.vulpecula.domainbackend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping
    String testFunc(){
        return "Hello World";
    }
}
