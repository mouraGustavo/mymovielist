package com.pw.movielist.principal.service;

import com.pw.movielist.principal.model.Usuario;
import com.pw.movielist.principal.model.dto.UsuarioDTO;
import com.pw.movielist.principal.repository.UsuarioRepository;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService{
    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public ResponseEntity<UsuarioDTO> criarUsuario(UsuarioDTO usuarioRequest){
        var usuario = new Usuario(usuarioRequest.getNome(), usuarioRequest.getEmail(), usuarioRequest.getSenha());
        usuarioRepository.save(usuario);
        return ResponseEntity.status(HttpStatus.OK).body(new UsuarioDTO(usuario));
    }

    public  ResponseEntity<List<UsuarioDTO>> buscarUsuarios(){
        return ResponseEntity.status(HttpStatus.OK).body(usuarioRepository.findAll().stream().map(UsuarioDTO::new).toList());
    }

    public ResponseEntity<UsuarioDTO> buscaUsuario(String email) {
        return ResponseEntity.status(HttpStatus.OK).body(
            usuarioRepository.findByEmail(email)
            .stream().map(UsuarioDTO::new).toList().get(0)
        );
    }

    public ResponseEntity<UsuarioDTO> buscarUsuarioPorID(Long id){
        return ResponseEntity.status(HttpStatus.OK).body(usuarioRepository.findById(id).stream().map(UsuarioDTO::new).toList().get(0));
    }
}

