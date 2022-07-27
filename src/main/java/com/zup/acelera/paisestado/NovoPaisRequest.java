package com.zup.acelera.paisestado;

import com.zup.acelera.model.Pais;
import com.zup.acelera.util.UniqueValue;

import javax.validation.constraints.NotBlank;

public class NovoPaisRequest {

    @NotBlank
    @UniqueValue(domainClass = Pais.class, fieldName = "nome")
    private String nome;

    public NovoPaisRequest(){}

    public NovoPaisRequest(@NotBlank String nome) {
        super();
        this.nome = nome;
    }

    public Pais toModel() {
        return new Pais(this.nome);
    }

    public String getNome() {
        return nome;
    }
}
