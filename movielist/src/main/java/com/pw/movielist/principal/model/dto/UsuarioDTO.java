package com.pw.movielist.principal.model.dto;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.pw.movielist.principal.model.Usuario;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class UsuarioDTO {
    private long id;
    private String nome;
    private String email;
    private String senha;
    
    public UsuarioDTO(Usuario usuario) {
        this.id = usuario.getId();
        this.nome = usuario.getNome();
        this.email = usuario.getEmail();
        this.senha = usuario.getSenha();
    }
    public UsuarioDTO(long id, String nome, String email, String senha) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public UsuarioDTO(){
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
    public static List<UsuarioDTO> toDTO(List<Usuario> origens) {
        return origens.stream().map(UsuarioDTO::new).collect(Collectors.toList());
    }
}

