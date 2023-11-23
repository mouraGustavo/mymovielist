package com.pw.movielist.principal.model.dto;

import com.pw.movielist.tmdb.dto.TmdbElencoDTO;
import com.pw.movielist.tmdb.dto.TmdbPessoaDTO;

import java.util.Objects;

public class CardPessoaDTO {
    private Long id;

    private String nome;

    private String cargo;

    private String urlImagem;

    public CardPessoaDTO(TmdbPessoaDTO pessoa) {
        this.id = pessoa.getId();
        this.nome = pessoa.getName();
        this.cargo = pessoa.getKnownForDepartment();
        this.urlImagem =  Objects.isNull(pessoa.getProfilePath()) ? "https://upload.wikimedia.org/wikipedia/commons/thumb/6/65/No-Image-Placeholder.svg/1665px-No-Image-Placeholder.svg.png" :"https://image.tmdb.org/t/p/original" + pessoa.getProfilePath();
    }
    public CardPessoaDTO(TmdbElencoDTO elenco) {
        this.id = elenco.getId();
        this.nome = elenco.getName();
        this.cargo = elenco.getKnownForDepartment();
        this.urlImagem = Objects.isNull(elenco.getProfilePath()) ? "https://upload.wikimedia.org/wikipedia/commons/thumb/6/65/No-Image-Placeholder.svg/1665px-No-Image-Placeholder.svg.png" :"https://image.tmdb.org/t/p/original" + elenco.getProfilePath();
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

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getUrlImagem() {
        return urlImagem;
    }

    public void setUrlImagem(String urlImagem) {
        this.urlImagem = urlImagem;
    }
}
