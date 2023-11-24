package com.pw.movielist.principal.controller;


import com.pw.movielist.principal.model.Usuario;
import com.pw.movielist.principal.model.dto.UsuarioDTO;
import com.pw.movielist.principal.repository.UsuarioRepository;

import io.swagger.v3.oas.annotations.Operation;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins= "*", maxAge = 36)
@RequestMapping("usuario")
public class UsuarioController {

    private final UsuarioRepository usuarioRepository;

    public UsuarioController(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }

    @GetMapping("/listar")
    @Operation(summary = "Retorna os usuários")
    public List<UsuarioDTO> getUsers(){
        final List<Usuario> origens = usuarioRepository.findAll();
        return UsuarioDTO.toDTO(origens);
    }

    @PostMapping("/cadastrar")
    @Operation(summary = "Cria um novo usuário")
    public Usuario criarUsuario(@RequestBody Usuario usuario){
        System.out.println("passei aqui");
        return usuarioRepository.save(usuario);
    }
}
