package com.pw.movielist.principal.repository;

import com.pw.movielist.principal.model.Usuario;
import com.pw.movielist.principal.model.dto.UsuarioDTO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	UsuarioDTO save(UsuarioDTO usuario);

    List<Usuario> findByEmail(String email);



}
