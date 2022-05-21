package com.vinicius.lds.greetingservice.controller;

import java.util.concurrent.atomic.AtomicLong;

import com.vinicius.lds.greetingservice.configuration.GreetingConfiguration;
import com.vinicius.lds.greetingservice.model.Greeting;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class GreetingController {
    
    private static final String TEMPLATE = "%s, %s";
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    private GreetingConfiguration greetingConfiguration;

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", required = false) String param) {
        final String name;
        if (param == null || param.isEmpty()) {
            name = greetingConfiguration.getDefaultValue();
        } else {
            name = param;
        }
        return new Greeting(counter.getAndIncrement(), String.format(TEMPLATE, greetingConfiguration.getGreeting(), name));
    }
    

}
