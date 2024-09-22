package com.example.inicial1.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.envers.Audited;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Builder
@Entity
@Table(name = "Domicilio")
@Audited
public class Domicilio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String calle;
    private int numero;

    @Builder.Default
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_domicilio")
    private List<Localidad> localidades = new ArrayList<>();
}
