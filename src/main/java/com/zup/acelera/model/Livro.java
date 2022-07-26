package com.zup.acelera.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Livro {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    Long id;
    @NotBlank
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
    private String isbn;
    @NotNull
    @Future
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate dataPublicacao;
    @ManyToOne
    private Autor autor;
    @ManyToOne
    private Categoria categoria;

    @Deprecated
    public Livro(){}

    public Livro(
            @NotBlank String titulo,
            @NotBlank String resumo,
            @NotBlank String sumario,
            @Min(100) BigDecimal preco,
            @NotNull @Min(100) int numeroPaginas,
            @NotBlank String isbn,
            @NotNull LocalDate dataPublicacao,
            Autor autor,
            Categoria categoria
    ) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.numeroPaginas = numeroPaginas;
        this.isbn = isbn;
        this.dataPublicacao = dataPublicacao;
        this.autor = autor;
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Livro{" +
                "titulo='" + titulo + '\'' +
                ", resumo='" + resumo + '\'' +
                ", sumario='" + sumario + '\'' +
                ", preco=" + preco +
                ", numeroPaginas=" + numeroPaginas +
                ", isbn='" + isbn + '\'' +
                ", dataPublicacao=" + dataPublicacao +
                ", autor=" + autor +
                ", categoria=" + categoria +
                '}';
    }
}
