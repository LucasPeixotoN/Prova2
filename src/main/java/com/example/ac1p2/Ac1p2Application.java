package com.example.ac1p2;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.ac1p2.models.*;
import com.example.ac1p2.repositories.*;
import java.util.Arrays;

@SpringBootApplication
public class Ac1p2Application {

    public static void main(String[] args) {
        SpringApplication.run(Ac1p2Application.class, args);
    }

    @Bean
    CommandLineRunner init(FilmeRepository filmeRepo, DiretorRepository diretorRepo) {
        return args -> {
            Diretor d1 = new Diretor("Greta Gerwig");
            Diretor d2 = new Diretor("Denis Villeneuve");

            Filme f1 = new Filme("Lady Bird", 94, d1);
            Filme f2 = new Filme("Adoráveis Mulheres", 135, d1);
            Filme f3 = new Filme("Duna", 155, d2);

            d1.setFilmes(Arrays.asList(f1, f2));
            d2.setFilmes(Arrays.asList(f3));

            diretorRepo.saveAll(Arrays.asList(d1, d2));

            System.out.println("\nFilmes com duração > 120");
            filmeRepo.findByDuracaoGreaterThan(120)
                    .forEach(f -> System.out.println(f.getTitulo()));

            System.out.println("\nFilmes com duração <= 120");
            filmeRepo.findByDuracaoLessThanEqual(120)
                    .forEach(f -> System.out.println(f.getTitulo()));

            System.out.println("\nFilmes que começam com 'La'");
            filmeRepo.findByTituloStartingWith("La")
                    .forEach(f -> System.out.println(f.getTitulo()));

            System.out.println("\nDiretor com filmes");
            diretorRepo.findByIdWithFilmes(d1.getId()).ifPresent(d -> {
                System.out.println("Diretor: " + d.getNome() + " (ID: " + d.getId() + ")");
                d.getFilmes().forEach(f -> System.out.println("  - " + f.getTitulo()));
            });
        };
    }
}