package com.pw.movielist.tmdb.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class CreditosDTO {

    @JsonProperty("cast")
    private List<TmdbElencoDTO> cast;
    @JsonProperty("crew")
    private List<TmdbElencoDTO> crew;

    public List<TmdbElencoDTO> getCast() {
        return cast;
    }

    public void setCast(List<TmdbElencoDTO> cast) {
        this.cast = cast;
    }

    public List<TmdbElencoDTO> getCrew() {
        return crew;
    }

    public void setCrew(List<TmdbElencoDTO> crew) {
        this.crew = crew;
    }
}
