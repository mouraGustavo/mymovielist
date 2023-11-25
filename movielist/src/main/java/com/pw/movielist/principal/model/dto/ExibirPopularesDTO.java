package com.pw.movielist.principal.model.dto;

import com.pw.movielist.tmdb.dto.TmdbDetalheFilmeDTO;

public class ExibirPopularesDTO {

    private Long id;

    private String nome;

    private String descricao;

    private String urlImagem;

    public ExibirPopularesDTO(TmdbDetalheFilmeDTO filme) {
        this.id = filme.getId();
        this.nome = filme.getTitle();
        this.urlImagem = "https://image.tmdb.org/t/p/original" + filme.getPosterPath();
        this.descricao = filme.getOverview();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getUrlImagem() {
        return urlImagem;
    }

    public void setUrlImagem(String urlImagem) {
        this.urlImagem = urlImagem;
    }
}
