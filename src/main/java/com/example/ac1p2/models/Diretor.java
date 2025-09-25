package com.example.ac1p2.models;

import java.util.List;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter; 

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Diretor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @OneToMany(mappedBy = "diretor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Filme> filmes;

    public Diretor(String nome) {
        this.nome = nome;
    }
}
