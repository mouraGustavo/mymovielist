package com.pw.movielist.principal.model.dto;

import com.pw.movielist.tmdb.dto.TmdbFilmeSerieDTO;

import java.util.Objects;

public class CardFilmeSerieDTO {

    private Long id;

    private String titulo;

    private String descricao;

    private String urlImagem;

    public CardFilmeSerieDTO(TmdbFilmeSerieDTO tmdbFilmeSerie) {
        this.id = tmdbFilmeSerie.getId();
        this.titulo = tmdbFilmeSerie.getTitle();
        this.descricao = tmdbFilmeSerie.getOverview();
        this.urlImagem = Objects.isNull(tmdbFilmeSerie.getPosterPath()) ? null : "https://image.tmdb.org/t/p/original" + tmdbFilmeSerie.getPosterPath();
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
