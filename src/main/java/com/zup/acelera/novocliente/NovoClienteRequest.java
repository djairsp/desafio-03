package com.zup.acelera.novocliente;

import com.zup.acelera.model.Cliente;
import com.zup.acelera.model.Estado;
import com.zup.acelera.model.Pais;
import com.zup.acelera.repository.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Optional;

public class NovoClienteRequest {


    @NotBlank
    @Email
    private String email;
    @NotBlank
    private String nome;
    @NotBlank
    private String sobreNome;
    @NotBlank
    //@UniqueValue(domainClass = Livro.class, fieldName = "???")
    private String documento;
    @NotBlank
    private String endereco;
    @NotBlank
    private String complemento;
    @NotBlank
    private String cidade;
    @NotNull
    private Long idPais;
    //criar validacao
    private Long idEstado;
    @NotBlank
    private String telefone;
    @NotBlank
    private String cep;

    @Deprecated
    public NovoClienteRequest(){}

    public NovoClienteRequest(@NotBlank String email, @NotBlank String nome, @NotBlank String sobreNome,
                              @NotBlank String documento, @NotBlank String endereco, @NotBlank String complemento,
                              @NotBlank String cidade, @NotNull Long idPais, Long idEstado, @NotBlank String telefone,
                              @NotBlank String cep) {
        this.email = email;
        this.nome = nome;
        this.sobreNome = sobreNome;
        this.documento = documento;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.idPais = idPais;
        this.idEstado = idEstado;
        this.telefone = telefone;
        this.cep = cep;
    }

    public Cliente toModel(PaisRepository paisRepository){

        Optional<Pais> pais = paisRepository.findById(idPais);
        Assert.state(pais.isPresent(), "Pais não informado ou nao existe!");

        Estado estado = null;
        if(pais.isPresent()){
            estado = pais.get().getEstadoByIdEstado(idEstado);
            Assert.state(estado != null, "Voce está tentando cadastrar um cliente " +
                    "mas precisa informar uma Estado do Pais informado!");
        }

        return new Cliente(email, nome, sobreNome, documento, endereco, complemento,
                cidade, pais.get(), estado, telefone, cep);
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

    public Long getIdPais() {
        return idPais;
    }

    public Long getIdEstado() {
        return idEstado;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getCep() {
        return cep;
    }
}
