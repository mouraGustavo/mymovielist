package com.pw.movielist.tmdb.client;

import com.pw.movielist.tmdb.dto.TmdbCabecalhoDTO;
import com.pw.movielist.tmdb.dto.TmdbFilmeSerieDTO;
import com.pw.movielist.tmdb.dto.TmdbPessoaDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value= "tmdb", url="https://api.themoviedb.org/3")
public interface IntegracaoTmdbClient {

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

    @GetMapping("/search/multi")
    TmdbCabecalhoDTO<TmdbFilmeSerieDTO> searchMulti(
            @RequestHeader("Authorization") String authorization,
            @RequestParam("query") String query,
            @RequestParam("include_adult") Boolean includeAdult,
            @RequestParam("language") String language,
            @RequestParam("page") Integer page
    );

    @GetMapping("/movie/{movie_id}")
    void findDetailsMovie(@PathVariable Long movie_id);

    @GetMapping("/search/person")
    TmdbCabecalhoDTO<TmdbPessoaDTO> searchPerson(
            @RequestHeader("Authorization") String authorization,
            @RequestParam("query") String query,
            @RequestParam("include_adult") Boolean includeAdult,
            @RequestParam("language") String language,
            @RequestParam("page") Integer page
    );


}
