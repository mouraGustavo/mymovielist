package com.pw.movielist.application.controller;

import com.pw.movielist.application.model.dto.CardFilmeDTO;
import com.pw.movielist.application.service.ConexaoTmdbService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("tmdb")
public class TmdbController {

    private final ConexaoTmdbService conexaoTmdbService;

    public TmdbController(ConexaoTmdbService conexaoTmdbService) {
        this.conexaoTmdbService = conexaoTmdbService;
    }

    @GetMapping("/buscar/filme")
    public List<CardFilmeDTO> pesquisaFilmes(@RequestParam String nomeFilme){
        return conexaoTmdbService.buscarCardFilmeTmdb(nomeFilme);
    }
}
