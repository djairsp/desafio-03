package com.zup.acelera.detalhelivro;

import com.zup.acelera.model.Autor;

public class DetalheSiteAutorResponse {

    private final String nome;
    private final String descricao;

    public DetalheSiteAutorResponse(Autor autor) {
        this.nome = autor.getNome();
        this.descricao = autor.getDescricao();
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }
}
