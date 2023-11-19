package com.pw.movielist.tmdb.service;

import com.pw.movielist.tmdb.client.IntegracaoTmdbClient;
import com.pw.movielist.tmdb.dto.*;
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

    public TmdbCabecalhoDTO<TmdbEmpresaDTO> buscarEmpresa(String busca){
        return tmdbClient.searchCompany("Bearer " + tokenAuth, busca, 1);
    }

    public TmdbCabecalhoDTO<TmdbFilmeSerieDTO> buscarFilme(String busca){
        return tmdbClient.searchMovie("Bearer " + tokenAuth, busca, false, "pt-BR", 1);
    }

    public TmdbCabecalhoDTO<TmdbFilmeSerieDTO> buscarSerie(String busca){
        return tmdbClient.searchTv("Bearer " + tokenAuth, busca, false, "pt-BR", 1);
    }

    public TmdbCabecalhoDTO<TmdbPessoaDTO> buscarPessoa(String busca){
        return tmdbClient.searchPerson("Bearer " + tokenAuth, busca, false, "pt-BR", 1);
    }

    public TmdbDetalheFilmeDTO detalharFilme(Long id){
        TmdbDetalheFilmeDTO filme = tmdbClient.findDetailsMovie("Bearer " + tokenAuth, "", "pt-BR", id);
        filme.setVideos(tmdbClient.findVideosMovie("Bearer " + tokenAuth, "",id));
        filme.setCredits(tmdbClient.findCreditsMovie("Bearer " + tokenAuth, "pt-BR",id));
        return filme;
    }

    public TmdbDetalheSerieDTO detalharSerie(Long id){
        return tmdbClient.findDetailsTv("Bearer " + tokenAuth, "","pt-BR", id);
    }

    public TmdbDetalhePessoaDTO detalharPessoa(Long id){
        return tmdbClient.findDetailsPerson("Bearer " + tokenAuth, "","pt-BR", id);
    }
    public TmdbDetalheEmpresaDTO detalharEmpresa(Long id){
        return tmdbClient.findDetailsCompany("Bearer " + tokenAuth, id);
    }

}
