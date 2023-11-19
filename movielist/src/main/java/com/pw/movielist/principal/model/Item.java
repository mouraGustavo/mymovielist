package com.pw.movielist.principal.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.pw.movielist.principal.model.dto.ItemDTO;
import jakarta.persistence.*;

@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_item")
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "status")
    private String status;

    @Column(name = "avaliacao")
    private String avaliacao;

    @Column(name = "comentario")
    private String comentario;

    @Column(name = "id_imdb")
    private String idImdb;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_lista")
    private Lista pertenceA;

    public Item(ItemDTO itemDTO) {
        this.nome = itemDTO.getNome();
        this.status = itemDTO.getStatus();
        this.avaliacao = itemDTO.getAvaliacao().toString();
        this.comentario = itemDTO.getComentario();
        this.idImdb = itemDTO.getIdTmdb();
    }

    public Item() {
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(String avaliacao) {
        this.avaliacao = avaliacao;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getIdImdb() {
        return idImdb;
    }

    public void setIdImdb(String idImdb) {
        this.idImdb = idImdb;
    }

    public Lista getPertenceA() {
        return pertenceA;
    }

    public void setPertenceA(Lista pertenceA) {
        this.pertenceA = pertenceA;
    }
}
