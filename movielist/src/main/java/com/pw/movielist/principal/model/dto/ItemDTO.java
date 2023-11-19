package com.pw.movielist.principal.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.pw.movielist.principal.model.Item;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ItemDTO {

    private Long id;

    private String nome;

    private String comentario;

    private Integer avaliacao;

    private String status;

    private String idTmdb;

    public ItemDTO(Item item) {
        this.id = item.getId();
        this.nome = item.getNome();
        this.comentario = item.getComentario();
        this.avaliacao = Integer.valueOf(item.getAvaliacao());
        this.status = item.getStatus();
        this.idTmdb = item.getIdImdb();
    }

    public ItemDTO(Long id, String nome, String comentario, Integer avaliacao, String status, String idTmdb) {
        this.id = id;
        this.nome = nome;
        this.comentario = comentario;
        this.avaliacao = avaliacao;
        this.status = status;
        this.idTmdb = idTmdb;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Integer getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(Integer avaliacao) {
        this.avaliacao = avaliacao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getIdTmdb() {
        return idTmdb;
    }

    public void setIdTmdb(String idTmdb) {
        this.idTmdb = idTmdb;
    }
}
