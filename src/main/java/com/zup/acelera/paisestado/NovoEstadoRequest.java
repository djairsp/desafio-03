package com.zup.acelera.paisestado;

import com.zup.acelera.model.Estado;
import com.zup.acelera.model.Pais;
import com.zup.acelera.util.UniqueValue;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class NovoEstadoRequest {

    @NotBlank
    @UniqueValue(domainClass = Estado.class, fieldName = "nome")
    private String nome;
    @NotNull
    //@ExistId(domainClass = Pais.class, fieldName = " ")
    private Long idPais;

    public NovoEstadoRequest(){}

    public NovoEstadoRequest(@NotBlank String nome, @NotNull Long idPais) {
        super();
        this.nome = nome;
        this.idPais = idPais;
    }

    public Estado toModel(EntityManager manager) {
        Pais pais = manager.find(Pais.class, idPais);
        Assert.state(pais != null, "Voce está querendo cadastrar um Estado para um Pais que nao existe");
        return new Estado(this.nome, pais);
    }

    public String getNome() {
        return nome;
    }

    public Long getIdPais() {
        return idPais;
    }
}
