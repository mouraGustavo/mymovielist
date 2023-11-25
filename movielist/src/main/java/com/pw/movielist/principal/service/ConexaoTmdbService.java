package com.pw.movielist.principal.service;

import com.pw.movielist.principal.model.dto.*;
import com.pw.movielist.tmdb.dto.TmdbFilmeSerieDTO;
import com.pw.movielist.tmdb.dto.TmdbPessoaDTO;
import com.pw.movielist.tmdb.service.TmdbService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ConexaoTmdbService {

    private final TmdbService tmdbService;

    public ConexaoTmdbService(TmdbService tmdbService) {
        this.tmdbService = tmdbService;
    }
    public CardMultiBuscaDTO buscarCardFilmePessoaSerie(String busca){
        CardMultiBuscaDTO resultadoBusca = new CardMultiBuscaDTO();

        resultadoBusca.setFilmes(tmdbService.buscarFilme(busca).getResults().stream().map(CardFilmeSerieDTO::new).toList());
        resultadoBusca.setSeries(tmdbService.buscarSerie(busca).getResults().stream().map(CardFilmeSerieDTO::new).toList());
        resultadoBusca.setPessoas(tmdbService.buscarPessoa(busca).getResults().stream().map(CardPessoaDTO::new).toList());
        resultadoBusca.setEmpresas(tmdbService.buscarEmpresa(busca).getResults().stream().map(CardEmpresaDTO::new).toList());

        return resultadoBusca;
    }

    public List<ExibirPopularesDTO> buscarFilmesPopulares(){
        return tmdbService.mostrarFilmesPopulares().getResults().stream().map(ExibirPopularesDTO::new).toList();
    }

    public List<CardFilmeSerieDTO> buscarCardFilmeTmdb(String busca){
        return tmdbService.buscarFilme(busca).getResults().stream().map(CardFilmeSerieDTO::new).collect(Collectors.toList());
    }

    public List<CardFilmeSerieDTO> buscarCardSerieTmdb(String busca){
        return tmdbService.buscarSerie(busca).getResults().stream().map(CardFilmeSerieDTO::new).collect(Collectors.toList());
    }

    public List<CardPessoaDTO> buscarCardPessoaTmdb(String busca){
        return tmdbService.buscarPessoa(busca).getResults().stream().map(CardPessoaDTO::new).collect(Collectors.toList());
    }

    public List<CardEmpresaDTO> buscarEmpresaTmdb(String busca){
        return tmdbService.buscarEmpresa(busca).getResults().stream().map(CardEmpresaDTO::new).collect(Collectors.toList());
    }
    public ExibirFilmeDTO detalharFilme(Long id){
        return new ExibirFilmeDTO(tmdbService.detalharFilme(id));
    }


}
