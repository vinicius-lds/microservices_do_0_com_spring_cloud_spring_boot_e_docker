package com.vinicius.lds.bookservice.model;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Book {
    
    @Id
    @GeneratedValue(generator = "hibernate-uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "id", unique = true, updatable = false)
    UUID id;

    @Column(name = "author", nullable = false, length = 180)
    String author;
    
    @Column(name = "launch_date", nullable = false)
    @Temporal(TemporalType.DATE)
    Date launchDate;

    @Column(name = "price", nullable = false)
    Double price;

    @Column(name = "title", nullable = false, length = 250)
    String title;

    @Transient
    String currency;

    @Transient
    String environment;

}
