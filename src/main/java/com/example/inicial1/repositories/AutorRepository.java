package com.example.inicial1.repositories;

import com.example.inicial1.entities.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository  extends JpaRepository<Autor, Long> {
}
