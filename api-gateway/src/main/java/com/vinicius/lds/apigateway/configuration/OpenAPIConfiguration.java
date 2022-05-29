package com.vinicius.lds.apigateway.configuration;

import java.util.List;

import org.springdoc.core.GroupedOpenApi;
import org.springdoc.core.SwaggerUiConfigParameters;
import org.springframework.cloud.gateway.route.RouteDefinitionLocator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
public class OpenAPIConfiguration {
    
    @Bean
    @Lazy(false)
    public List<GroupedOpenApi> apis(SwaggerUiConfigParameters params, RouteDefinitionLocator locator) {
        var definitions = locator.getRouteDefinitions().collectList().block();
        definitions.stream()
            .filter(definidion -> definidion.getId().matches(".*-service"))
            .forEach(definidion -> {
                var name = definidion.getId();
                params.addGroup(name);
                GroupedOpenApi.builder()
                    .pathsToMatch("/" + name + "/**")
                    .group(name)
                    .build();
            });
        return List.of();
    }

}
