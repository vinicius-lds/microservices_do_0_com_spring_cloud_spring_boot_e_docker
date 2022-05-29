package com.vinicius.lds.cambioservice.controller;

import java.math.BigDecimal;
import java.math.RoundingMode;

import com.vinicius.lds.cambioservice.exceptions.NotFoundException;
import com.vinicius.lds.cambioservice.model.Cambio;
import com.vinicius.lds.cambioservice.repository.CambioRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AccessLevel;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Tag(name = "Cambio Service API")
@RestController
@Setter(onMethod_ = @Autowired)
@RequestMapping("cambio-service")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CambioController {

    @Setter(AccessLevel.NONE)
    Logger logger = LoggerFactory.getLogger(CambioController.class);

    CambioRepository repository;
    Environment environment;
    
    @Operation(summary = "Get cambio from currency")
    @GetMapping("/{amount}/{from}/{to}")
    public Cambio getCambio(
        @PathVariable("amount") BigDecimal amount,
        @PathVariable("from") String from,
        @PathVariable("to") String to
    ) {
        logger.info("getCambio called with: {}, {}, {}.", amount, from, to);
        
        final String port = environment.getProperty("local.server.port");
        final Cambio cambio = repository.findByFromAndTo(from, to).orElseThrow(NotFoundException::new);

        final BigDecimal conversionFactor = cambio.getConversionFactor();
        final BigDecimal convertedValue = conversionFactor.multiply(amount);

        cambio.setConvetedValue(convertedValue.setScale(2, RoundingMode.CEILING));
        cambio.setEnvironment(port);

        return cambio;
    }

}
