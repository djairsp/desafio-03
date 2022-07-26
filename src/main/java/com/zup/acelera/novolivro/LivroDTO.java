package com.zup.acelera.novolivro;

import com.zup.acelera.model.Livro;

import java.util.List;
import java.util.stream.Collectors;

public class LivroDTO {
    private Long id;
    private String titulo;

    public LivroDTO(Livro livro) {
        this.id = livro.getId();
        this.titulo = livro.getTitulo();
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public static List<LivroDTO> converter(List<Livro> topicos) {
        return topicos.stream().map(LivroDTO::new).collect(Collectors.toList());
    }
}
