package com.example.inicial1.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.envers.Audited;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
@Entity
@Table(name = "Libro")
@Audited

public class Libro implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private int fecha;
    private String genero;
    private int paginas;
    private String autor;


    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name= "libro_autor", joinColumns = @JoinColumn(name="libro_id"), inverseJoinColumns = @JoinColumn(name="autor_id"))
    @Builder.Default
    private List<Autor> autores = new ArrayList<>();
}
