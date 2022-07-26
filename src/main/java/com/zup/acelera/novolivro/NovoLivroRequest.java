package com.zup.acelera.novolivro;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.zup.acelera.model.Autor;
import com.zup.acelera.model.Categoria;
import com.zup.acelera.model.Livro;
import com.zup.acelera.util.UniqueValue;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public class NovoLivroRequest {

    @NotBlank
    @UniqueValue(domainClass = Livro.class, fieldName = "titulo")
    private String titulo;
    @NotBlank
    private String resumo;
    @NotBlank
    @Size(max = 500)
    private String sumario;
    @NotNull
    @Min(20)
    private BigDecimal preco;
    @Min(100)
    private int numeroPaginas;
    @NotBlank
    @UniqueValue(domainClass = Livro.class, fieldName = "isbn")
    private String isbn;
    @Future
    @NotNull
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate dataPublicacao;
    @NotNull
    //@ExistId(domainClass = Categoria.class, fieldName = " ")
    private Long idCategoria;
    @NotNull
    //@ExistId(domainClass = Autor.class, fieldName = " ")
    private Long idAutor;

    public NovoLivroRequest(@NotBlank String titulo,
                            @NotBlank String resumo,
                            @NotBlank String sumario,
                            @Min(100) BigDecimal preco,
                            @NotNull @Min(100) int numeroPaginas,
                            @NotBlank String isbn,
                            Long idCategoria,
                            Long idAutor) {
        super();
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.numeroPaginas = numeroPaginas;
        this.isbn = isbn;
        this.idCategoria = idCategoria;
        this.idAutor = idAutor;
    }

    public void setDataPublicacao(LocalDate dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public Livro toModel(EntityManager manager) {
        Autor autor = manager.find(Autor.class, idAutor);
        Categoria categoria = manager.find(Categoria.class, idCategoria);

        Assert.state(autor != null, "Voce está querendo cadastrar um livro para um autor que nao existe");
        Assert.state(categoria != null, "Voce está querendo cadastrar um livro para uma categoria que nao existe");

        return new Livro(titulo, resumo, sumario, preco, numeroPaginas, isbn, dataPublicacao, autor, categoria);
    }
}
