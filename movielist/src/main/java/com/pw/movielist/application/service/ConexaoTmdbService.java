package com.pw.movielist.application.service;

import com.pw.movielist.application.model.dto.CardFilmeDTO;
import com.pw.movielist.tmdb.dto.TmdbFilmeSerieDTO;
import com.pw.movielist.tmdb.service.TmdbService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ConexaoTmdbService {

    private final TmdbService tmdbService;

    public ConexaoTmdbService(TmdbService tmdbService) {
        this.tmdbService = tmdbService;
    }

    public List<CardFilmeDTO> buscarCardFilmeTmdb(String nomeFilme){
        return tmdbService.buscarFilmes(nomeFilme).getResults().stream().map(CardFilmeDTO::new).collect(Collectors.toList());
    }

}
