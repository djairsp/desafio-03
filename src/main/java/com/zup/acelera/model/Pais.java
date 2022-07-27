package com.zup.acelera.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
public class Pais {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String nome;

    @OneToMany
    private List<Estado> estados;

    @Deprecated
    public Pais() {}

    public Pais(@NotBlank String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public List<Estado> getEstados() {
        return estados;
    }

    public Estado getEstadoByIdEstado(Long idEstado){
        return this.estados.stream().filter(estado -> estado.getId().equals(idEstado))
                .findAny()
                .orElse(null);
    }
}
