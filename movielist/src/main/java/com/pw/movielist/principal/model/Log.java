package com.pw.movielist.principal.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Log {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_log")
    private Long id;

    @Column(name = "id_usuario")
    private Long idUsuario;

    @Column(name = "acao")
    private String acao;

    @Column(name = "id_tmdb")
    private Long tmdbFilme;

    @Column(name = "data_acao")
    private Date dataAcao;

    public Log(Long idUsuario, String acao, Long tmdbFilme, Date dataAcao) {
        this.idUsuario = idUsuario;
        this.acao = acao;
        this.tmdbFilme = tmdbFilme;
        this.dataAcao = dataAcao;
    }

    public Log() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTmdbFilme() {
        return tmdbFilme;
    }

    public void setTmdbFilme(Long tmdbFilme) {
        this.tmdbFilme = tmdbFilme;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getAcao() {
        return acao;
    }

    public void setAcao(String acao) {
        this.acao = acao;
    }

    public Date getDataAcao() {
        return dataAcao;
    }

    public void setDataAcao(Date dataAcao) {
        this.dataAcao = dataAcao;
    }
}
