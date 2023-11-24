package com.pw.movielist.principal.repository;

import com.pw.movielist.principal.model.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
