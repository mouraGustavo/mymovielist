package com.pw.movielist.principal.controller;

import com.pw.movielist.principal.model.dto.UsuarioDTO;
import com.pw.movielist.principal.service.UsuarioService;

import io.swagger.v3.oas.annotations.Operation;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins= "*", maxAge = 36)
@RequestMapping("usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }

    @GetMapping("/listar")
    @Operation(summary = "Retorna os usuários")
    public ResponseEntity<List<UsuarioDTO>> getUsers(){
        return usuarioService.buscarUsuarios();
    }

    @GetMapping("/login")
    @Operation(summary = "Verifica usuario")
    public ResponseEntity<UsuarioDTO> getByEmail(@RequestParam String email){
        return usuarioService.buscaUsuario(email);
    }

    @PostMapping("/cadastrar")
    @Operation(summary = "Cria um novo usuário")
    public ResponseEntity<UsuarioDTO> criarUsuario(@RequestBody UsuarioDTO usuario){
        System.out.println("passei aqui");
        return usuarioService.criarUsuario(usuario);
    }
}
