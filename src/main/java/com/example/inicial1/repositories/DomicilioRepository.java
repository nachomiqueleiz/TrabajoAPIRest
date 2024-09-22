package com.example.inicial1.repositories;

import com.example.inicial1.entities.Domicilio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DomicilioRepository extends JpaRepository<Domicilio, Long> {
}
