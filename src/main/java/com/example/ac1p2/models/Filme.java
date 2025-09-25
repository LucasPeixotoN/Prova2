package com.example.ac1p2.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Filme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    private Integer duracao; // em minutos

    @ManyToOne
    @JoinColumn(name = "diretor_id")
    private Diretor diretor;

    public Filme(String titulo, Integer duracao, Diretor diretor) {
        this.titulo = titulo;
        this.duracao = duracao;
        this.diretor = diretor;
    }
}