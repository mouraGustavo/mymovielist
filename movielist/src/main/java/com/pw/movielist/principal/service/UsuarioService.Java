package com.pw.movielist.principal.service;

import com.pw.movielist.principal.model.Usuario;
import com.pw.movielist.principal.model.dto.UsuarioDTO;
import com.pw.movielist.principal.repository.UsuarioRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService{
    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public ResponseEntity<String> criarUsuario(UsuarioDTO usuarioRequest){
        var usuario = new Usuario(usuarioRequest.getNome(), usuarioRequest.getEmail(), usuarioRequest.getSenha());
        usuarioRepository.save(usuario);
        return ResponseEntity.status(HttpStatus.OK).body("Usuario criado com sucesso!");
    }
}
