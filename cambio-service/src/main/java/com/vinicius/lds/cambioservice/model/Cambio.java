package com.vinicius.lds.cambioservice.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
public class Cambio {
    
    @Id
    @GeneratedValue(generator = "hibernate-uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "id", unique = true, updatable = false)
    UUID id;

    @Column(name = "from_currency", nullable = false, length = 3)
    String from;

    @Column(name = "to_currency", nullable = false, length = 3)
    String to;

    @Column(nullable = false)
    BigDecimal conversionFactor;
    
    @Transient
    BigDecimal convetedValue;
    
    @Transient
    String environment;

}
