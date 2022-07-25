package com.zup.acelera.novacategoria;

import com.zup.acelera.model.Categoria;
import com.zup.acelera.util.UniqueValue;

import javax.validation.constraints.NotBlank;

public class NovaCategoriaRequest {

    @NotBlank
    @UniqueValue(domainClass = Categoria.class, fieldName = "nome")
    private String nome;

    @Deprecated
    public NovaCategoriaRequest(){}

    public NovaCategoriaRequest(@NotBlank String nome) {
        super();
        this.nome = nome;
    }

    public Categoria toModel() {
        return new Categoria(this.nome);
    }

    public String getNome() {
        return this.nome;
    }
}
