package com.pw.movielist.principal.controller;

import com.pw.movielist.principal.model.dto.ListaDTO;
import com.pw.movielist.principal.model.dto.UsuarioDTO;
import com.pw.movielist.principal.service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins= "*", maxAge = 36)
@RequestMapping({"usuario"})
public class UsuarioController {
    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }

    @PostMapping("/")
    public ResponseEntity<String> criarUsuario(@RequestBody UsuarioDTO usuario){
        return usuarioService.criarUsuario(usuario);
    }

}
