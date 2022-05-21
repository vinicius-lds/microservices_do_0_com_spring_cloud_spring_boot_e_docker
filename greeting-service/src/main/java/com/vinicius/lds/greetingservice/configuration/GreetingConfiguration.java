package com.vinicius.lds.greetingservice.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Setter
@Getter
@Component
@RefreshScope
@ConfigurationProperties("greeting-service")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GreetingConfiguration {
    
    String greeting;
    String defaultValue;

}
