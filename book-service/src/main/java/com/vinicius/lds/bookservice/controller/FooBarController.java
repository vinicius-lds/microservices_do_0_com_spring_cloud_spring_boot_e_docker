package com.vinicius.lds.bookservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AccessLevel;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Tag(name = "Foo bar")
@RestController
@Setter(onMethod_ = @Autowired)
@RequestMapping("book-service")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FooBarController {

    @Setter(value = AccessLevel.NONE)
    Logger logger = LoggerFactory.getLogger(FooBarController.class);

    // Define as propriedades para dar um retry no endpoint em caso de falha
    // @Retry(name = "foo-bar", fallbackMethod = "fallbackMethod") 
    // Define que em caso de falhas constantes na chamada, deve-se começar a chamar direto o fallback
    // @CircuitBreaker(name = "default", fallbackMethod = "fallbackMethod") 
    // Define um limite de chamadas em um determinado periodo de tempo
    // @RateLimiter(name = "default") 
    // Permite definir uma quanditdade máxima de chamadas concorrentes
    @Bulkhead(name = "default")
    @Operation(summary = "Foo bar")
    @GetMapping("/foo-bar")
    public String foorBar() {
        logger.info("Request to foo-bar received");
        // var response = new RestTemplate()
        //     .getForEntity("http://localhost:8080/foor-bar", String.class);

        // return response.getBody();
        return "foo-bar";
    }

    public String fallbackMethod(Exception e) {
        return "foo-bar " + e.getMessage();
    }

}
