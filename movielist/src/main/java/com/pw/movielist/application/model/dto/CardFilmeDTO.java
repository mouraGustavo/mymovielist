package com.pw.movielist.application.model.dto;

import com.pw.movielist.tmdb.dto.TmdbFilmeSerieDTO;

public class CardFilmeDTO {
    private Long id;

    private String titulo;

    private String descricao;

    private String urlImagem;

    public CardFilmeDTO(TmdbFilmeSerieDTO tmdbFilme) {
        this.id = tmdbFilme.getId();
        this.titulo = tmdbFilme.getTitle();
        this.descricao = tmdbFilme.getOverview();
        this.urlImagem = "https://image.tmdb.org/t/p/original" + tmdbFilme.getPosterPath();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
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
