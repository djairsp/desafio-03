package com.zup.acelera.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Optional;

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String email;
    @NotBlank
    private String nome;
    @NotBlank
    private String sobreNome;
    @NotBlank
    private String documento;
    @NotBlank
    private String endereco;
    @NotBlank
    private String complemento;
    @NotBlank
    private String cidade;
    @ManyToOne
    private Pais pais;
    //criar validacao
    @ManyToOne
    private Estado estado;
    @NotBlank
    private String telefone;
    @NotBlank
    private String cep;

    @Deprecated
    public Cliente() {}

    public Cliente(@NotBlank String email, @NotBlank String nome, @NotBlank String sobreNome,
                   @NotBlank String documento, @NotBlank String endereco, @NotBlank String complemento,
                   @NotBlank String cidade, Pais pais, Estado estado,
                   @NotBlank String telefone, @NotBlank String cep) {

        this.email = email;
        this.nome = nome;
        this.sobreNome = sobreNome;
        this.documento = documento;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.pais = pais;
        this.estado = estado;
        this.telefone = telefone;
        this.cep = cep;
    }

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public String getSobreNome() {
        return sobreNome;
    }

    public String getDocumento() {
        return documento;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getCidade() {
        return cidade;
    }

    public Pais getPais() {
        return pais;
    }

    public Estado getEstado() {
        return estado;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getCep() {
        return cep;
    }
}
