package com.pw.movielist.principal.model.dto;

import java.util.List;

public class CardMultiBuscaDTO {
    private List<CardPessoaDTO> pessoas;

    private List<CardFilmeSerieDTO> series;

    private List<CardFilmeSerieDTO> filmes;

    private List<CardEmpresaDTO> empresas;

    public List<CardPessoaDTO> getPessoas() {
        return pessoas;
    }

    public void setPessoas(List<CardPessoaDTO> pessoas) {
        this.pessoas = pessoas;
    }

    public List<CardFilmeSerieDTO> getSeries() {
        return series;
    }

    public void setSeries(List<CardFilmeSerieDTO> series) {
        this.series = series;
    }

    public List<CardFilmeSerieDTO> getFilmes() {
        return filmes;
    }

    public void setFilmes(List<CardFilmeSerieDTO> filmes) {
        this.filmes = filmes;
    }

    public List<CardEmpresaDTO> getEmpresas() {
        return empresas;
    }

    public void setEmpresas(List<CardEmpresaDTO> empresas) {
        this.empresas = empresas;
    }
}
