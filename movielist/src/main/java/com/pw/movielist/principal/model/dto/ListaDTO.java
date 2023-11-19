package com.pw.movielist.principal.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.pw.movielist.principal.model.Lista;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ListaDTO {

    private Long id;

    private Long idUsuario;

    private String nome;

    private List<ItemDTO> itens;

    public ListaDTO(Lista lista) {
        this.id = lista.getId();
        this.idUsuario = lista.getUsuario().getId();
        this.nome = lista.getNome();
        this.itens = lista.getListaItem().stream().map(ItemDTO::new).collect(Collectors.toList());
    }

    public ListaDTO(Long id, Long idUsuario, String nome) {
        this.id = id;
        this.idUsuario = idUsuario;
        this.nome = nome;
    }

    public ListaDTO(Long id, Long idUsuario, String nome, List<ItemDTO> itens) {
        this.id = id;
        this.idUsuario = idUsuario;
        this.nome = nome;
        this.itens = itens;
    }

    public ListaDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<ItemDTO> getItens() {
        return itens;
    }

    public void setItens(List<ItemDTO> itens) {
        this.itens = itens;
    }
}
