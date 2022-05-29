package com.vinicius.lds.bookservice.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.vinicius.lds.bookservice.exceptions.NotFoundException;
import com.vinicius.lds.bookservice.model.Book;
import com.vinicius.lds.bookservice.proxy.CambioProxy;
import com.vinicius.lds.bookservice.repository.BookRepository;
import com.vinicius.lds.bookservice.response.Cambio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AccessLevel;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Tag(name = "Book Endpoint")
@RestController
@Setter(onMethod_ = @Autowired)
@RequestMapping("book-service")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BookController {
    
    BookRepository repository;
    CambioProxy cambioProxy;
    Environment environment;

    @Operation(summary = "Find specific book by your ID")
    @GetMapping(value = "/{id}/{currency}")
    public Book findBook(@PathVariable("id") UUID id, @PathVariable("currency") String currency) {
        final Book book = repository.findById(id).orElseThrow(NotFoundException::new);

        final Cambio response = cambioProxy.getCambio(book.getPrice(), "USD", currency);
        book.setPrice(response.getConvetedValue());

        final String port = environment.getProperty("local.server.port");
        book.setEnvironment(String.format("book-service port %s; cambio-service port %s.", port, response.getEnvironment()));

        return book;
    }

}
