package com.example.inicial1.repositories;

import com.example.inicial1.entities.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibroRepository  extends JpaRepository<Libro, Long> {
}
