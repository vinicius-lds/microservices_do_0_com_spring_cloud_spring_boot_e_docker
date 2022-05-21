package com.vinicius.lds.greetingservice.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Setter
@Getter
@Component
@ConfigurationProperties("greeting-service")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GreetingConfiguration {
    
    String greeting;
    String defaultValue;

}
