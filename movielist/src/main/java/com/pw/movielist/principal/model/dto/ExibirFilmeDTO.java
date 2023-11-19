package com.pw.movielist.principal.model.dto;

import com.pw.movielist.tmdb.dto.GenreDTO;
import com.pw.movielist.tmdb.dto.TmdbDetalheFilmeDTO;
import com.pw.movielist.tmdb.dto.TmdbElencoDTO;

import java.util.List;
import java.util.stream.Collectors;

public class ExibirFilmeDTO {
    private String urlCapa;

    private String urlImagemFundo;

    private String titulo;

    private List<String> generos;

    private String dataLancamento;

    private String tituloOriginal;

    private String situacao;

    private String idiomaOriginal;

    private List<CardPessoaDTO> diretoresEscritores;

    private List<CardPessoaDTO> elencoPrincipal;

    private String assistaEm;

    private String duracao;

    private List<String> trailers;

    public ExibirFilmeDTO(TmdbDetalheFilmeDTO filme) {
        this.urlCapa = "https://image.tmdb.org/t/p/original" + filme.getPosterPath();
        this.urlImagemFundo = "https://image.tmdb.org/t/p/original" + filme.getBackdropPath();
        this.titulo = filme.getTitle();
        this.generos = filme.getGenres().stream().map(GenreDTO::getName).collect(Collectors.toList());
        this.dataLancamento = filme.getReleaseDate();
        this.tituloOriginal = filme.getOriginalTitle();
        this.situacao = filme.getStatus();
        this.idiomaOriginal = filme.getOriginalLanguage();
        this.diretoresEscritores = filme.getCredits().getCrew()
                .stream()
                .filter(cast -> cast.getJob().equals("Director") || cast.getJob().equals("Writer") || cast.getJob().equals("Screenplay"))
                .map(CardPessoaDTO::new).collect(Collectors.toList());
        this.elencoPrincipal = filme.getCredits().getCast()
                .stream().limit(10)
                .map(CardPessoaDTO::new)
                .collect(Collectors.toList());
        this.assistaEm = filme.getHomepage();
        this.duracao = filme.getRuntime() / 60 + "h" + filme.getRuntime() % 60 + "m";
        this.trailers = filme.getVideos().getResults()
                .stream()
                .filter(trailer -> trailer.getSite().equals("YouTube") && trailer.getType().equals("Trailer"))
                .map(trailer -> "https://www.youtube.com/watch?v=" + trailer.getKey())
                .collect(Collectors.toList());;
    }

    public String getUrlCapa() {
        return urlCapa;
    }

    public void setUrlCapa(String urlCapa) {
        this.urlCapa = urlCapa;
    }

    public String getUrlImagemFundo() {
        return urlImagemFundo;
    }

    public void setUrlImagemFundo(String urlImagemFundo) {
        this.urlImagemFundo = urlImagemFundo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<String> getGeneros() {
        return generos;
    }

    public void setGeneros(List<String> generos) {
        this.generos = generos;
    }

    public String getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(String dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public String getTituloOriginal() {
        return tituloOriginal;
    }

    public void setTituloOriginal(String tituloOriginal) {
        this.tituloOriginal = tituloOriginal;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public String getIdiomaOriginal() {
        return idiomaOriginal;
    }

    public void setIdiomaOriginal(String idiomaOriginal) {
        this.idiomaOriginal = idiomaOriginal;
    }

    public List<CardPessoaDTO> getDiretoresEscritores() {
        return diretoresEscritores;
    }

    public void setDiretoresEscritores(List<CardPessoaDTO> diretoresEscritores) {
        this.diretoresEscritores = diretoresEscritores;
    }

    public List<CardPessoaDTO> getElencoPrincipal() {
        return elencoPrincipal;
    }

    public void setElencoPrincipal(List<CardPessoaDTO> elencoPrincipal) {
        this.elencoPrincipal = elencoPrincipal;
    }

    public String getAssistaEm() {
        return assistaEm;
    }

    public void setAssistaEm(String assistaEm) {
        this.assistaEm = assistaEm;
    }

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }

    public List<String> getTrailers() {
        return trailers;
    }

    public void setTrailers(List<String> trailers) {
        this.trailers = trailers;
    }
}
