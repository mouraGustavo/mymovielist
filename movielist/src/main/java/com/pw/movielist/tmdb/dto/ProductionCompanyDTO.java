package com.pw.movielist.tmdb.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductionCompanyDTO{
    private int id;

    @JsonProperty("logo_path")
    private String logoPath;
    private String name;
    @JsonProperty("origin_country")
    private String originCountry;


}
