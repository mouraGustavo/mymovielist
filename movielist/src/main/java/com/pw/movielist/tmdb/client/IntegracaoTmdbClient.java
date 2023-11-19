package com.pw.movielist.tmdb.client;

import com.pw.movielist.tmdb.dto.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value= "tmdb", url="${rest.tmdb.url}")
public interface IntegracaoTmdbClient {
    @GetMapping("/search/company")
    TmdbCabecalhoDTO<TmdbEmpresaDTO> searchCompany(
            @RequestHeader("Authorization") String authorization,
            @RequestParam("query") String query,
            @RequestParam("page") Integer page
    );

    @GetMapping("/search/movie")
    TmdbCabecalhoDTO<TmdbFilmeSerieDTO> searchMovie(
            @RequestHeader("Authorization") String authorization,
            @RequestParam("query") String query,
            @RequestParam("include_adult") Boolean includeAdult,
            @RequestParam("language") String language,
            @RequestParam("page") Integer page
    );

    @GetMapping("/search/tv")
    TmdbCabecalhoDTO<TmdbFilmeSerieDTO> searchTv(
            @RequestHeader("Authorization") String authorization,
            @RequestParam("query") String query,
            @RequestParam("include_adult") Boolean includeAdult,
            @RequestParam("language") String language,
            @RequestParam("page") Integer page
    );

    @GetMapping("/search/person")
    TmdbCabecalhoDTO<TmdbPessoaDTO> searchPerson(
            @RequestHeader("Authorization") String authorization,
            @RequestParam("query") String query,
            @RequestParam("include_adult") Boolean includeAdult,
            @RequestParam("language") String language,
            @RequestParam("page") Integer page
    );

    @GetMapping("/movie/{movieId}")
    TmdbDetalheFilmeDTO findDetailsMovie(
            @RequestHeader("Authorization") String authorization,
            @RequestParam("append_to_response") String appendToResponse,
            @RequestParam("language") String language,
            @PathVariable Long movieId);

    @GetMapping("/movie/{movieId}/credits")
    CreditosDTO findCreditsMovie(
            @RequestHeader("Authorization") String authorization,
            @RequestParam("language") String language,
            @PathVariable Long movieId);

    @GetMapping("/movie/{movieId}/videos")
    TmdbCabecalhoDTO<VideoDTO> findVideosMovie(
            @RequestHeader("Authorization") String authorization,
            @RequestParam("language") String language,
            @PathVariable Long movieId);

    //@GetMapping("/movie/{movieId}/watch/providers")
    //TODO: findWhereToWatchMovie(@RequestHeader("Authorization") String authorization, @PathVariable Long movieId);

    @GetMapping("/tv/{seriesId}")
    TmdbDetalheSerieDTO findDetailsTv(
            @RequestHeader("Authorization") String authorization,
            @RequestParam("append_to_response") String appendToResponse,
            @RequestParam("language") String language,
            @PathVariable Long seriesId);

    @GetMapping("/person/{personId}")
    TmdbDetalhePessoaDTO findDetailsPerson(
            @RequestHeader("Authorization") String authorization,
            @RequestParam("append_to_response") String appendToResponse,
            @RequestParam("language") String language,
            @PathVariable Long personId);

    @GetMapping("/company/{companyId}")
    TmdbDetalheEmpresaDTO findDetailsCompany(@RequestHeader("Authorization") String authorization, @PathVariable Long companyId);

}
