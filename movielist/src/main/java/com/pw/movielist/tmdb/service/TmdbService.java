package com.pw.movielist.tmdb.service;

import com.pw.movielist.tmdb.client.IntegracaoTmdbClient;
import com.pw.movielist.tmdb.dto.TmdbCabecalhoDTO;
import com.pw.movielist.tmdb.dto.TmdbFilmeSerieDTO;
import com.pw.movielist.tmdb.dto.TmdbPessoaDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class TmdbService {
    @Value("${rest.tmdb.token}")
    private String tokenAuth;
    private final IntegracaoTmdbClient tmdbClient;

    public TmdbService(IntegracaoTmdbClient tmdbClient) {
        this.tmdbClient = tmdbClient;
    }
    public TmdbCabecalhoDTO<TmdbFilmeSerieDTO> buscarFilmes(String busca){
        return tmdbClient.searchMovie("Bearer " + tokenAuth, busca, false, "pt-BR", 1);
    }
    public TmdbCabecalhoDTO<TmdbFilmeSerieDTO> buscarSeries(String busca){
        return tmdbClient.searchTv("Bearer " + tokenAuth, busca, false, "pt-BR", 1);
    }
    public TmdbCabecalhoDTO<TmdbPessoaDTO> buscarPessoa(String busca){
        return tmdbClient.searchPerson("Bearer " + tokenAuth, busca, false, "pt-BR", 1);
    }
    public TmdbCabecalhoDTO<?> buscarFilmesSeriesPessoas(String busca){
        return tmdbClient.searchMulti("Bearer " + tokenAuth, busca, false, "pt-BR", 1);
    }
}
