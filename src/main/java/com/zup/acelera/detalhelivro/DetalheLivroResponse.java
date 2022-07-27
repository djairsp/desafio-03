package com.zup.acelera.detalhelivro;

import com.zup.acelera.model.Livro;

import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;

public class DetalheLivroResponse {

    private final String titulo;
    private final DetalheSiteAutorResponse autor;
    private final String isbn;
    private final int numeroPaginas;
    private final BigDecimal preco;
    private final String resumo;
    private final String sumario;
    private final String dataPublicacao;

    public DetalheLivroResponse(Livro livro) {
        this.autor = new DetalheSiteAutorResponse(livro.getAutor());
        this.titulo = livro.getTitulo();
        this.isbn = livro.getIsbn();
        this.numeroPaginas = livro.getNumeroPaginas();
        this.preco = livro.getPreco();
        this.resumo = livro.getResumo();
        this.sumario = livro.getSumario();
        this.dataPublicacao = livro.getDataPublicacao()
                .format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    public String getTitulo() {
        return titulo;
    }

    public DetalheSiteAutorResponse getAutor() {
        return autor;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public String getResumo() {
        return resumo;
    }

    public String getSumario() {
        return sumario;
    }

    public String getDataPublicacao() {
        return dataPublicacao;
    }
}
