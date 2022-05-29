package com.vinicius.lds.cambioservice.repository;

import java.util.Optional;
import java.util.UUID;

import com.vinicius.lds.cambioservice.model.Cambio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CambioRepository extends JpaRepository<Cambio, UUID> {
    
    Optional<Cambio> findByFromAndTo(String from, String to);

}
