package com.vinicius.lds.bookservice.repository;

import java.util.UUID;

import com.vinicius.lds.bookservice.model.Book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, UUID> {
    
}
