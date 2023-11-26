package com.pw.movielist.principal.controller;

import com.pw.movielist.principal.model.dto.UsuarioDTO;
import com.pw.movielist.principal.service.UsuarioService;

import io.swagger.v3.oas.annotations.Operation;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/currentUser")
    @Operation(summary = "Resgata o usuario logado")
    public ResponseEntity<UsuarioDTO> getByID(@RequestParam Long id){
        return usuarioService.buscarUsuarioPorID(id);
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

    @PostMapping("/{idUsuario}/atualizar")
    @Operation(summary = "Atualizar as informações de um usuário")
    public ResponseEntity<UsuarioDTO> atualizarUsuario(@PathVariable Long idUsuario, @RequestBody UsuarioDTO usuario){
        return usuarioService.atualizarUsuario(idUsuario, usuario);
    }
}
