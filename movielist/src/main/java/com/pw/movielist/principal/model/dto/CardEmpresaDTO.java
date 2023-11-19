package com.pw.movielist.principal.model.dto;

import com.pw.movielist.tmdb.dto.TmdbEmpresaDTO;

public class CardEmpresaDTO {
    private Long id;

    private String nome;

    private String urlImagem;

    public CardEmpresaDTO(TmdbEmpresaDTO empresa) {
        this.id = empresa.getId();
        this.nome = empresa.getName();
        this.urlImagem = empresa.getLogoPath();//TODO: CASO A LOGO DA EMPRESA VENHA VAZIA SETAR UMA IMAGEM PADRÃO DE LOGO
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

    public String getUrlImagem() {
        return urlImagem;
    }

    public void setUrlImagem(String urlImagem) {
        this.urlImagem = urlImagem;
    }
}
