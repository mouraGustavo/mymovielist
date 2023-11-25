package com.pw.movielist.principal.controller;

import com.pw.movielist.principal.model.dto.CardFilmeSerieDTO;
import com.pw.movielist.principal.model.dto.CardMultiBuscaDTO;
import com.pw.movielist.principal.model.dto.CardPessoaDTO;
import com.pw.movielist.principal.model.dto.ExibirFilmeDTO;
import com.pw.movielist.principal.service.ConexaoTmdbService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins= "*", maxAge = 36)
@RequestMapping("card")
public class CardController {

    private final ConexaoTmdbService conexaoTmdbService;

    public CardController(ConexaoTmdbService conexaoTmdbService) {
        this.conexaoTmdbService = conexaoTmdbService;
    }

    @GetMapping("/populares")
    public List<ExibirFilmeDTO> mostrarPopulares(){
        return conexaoTmdbService.buscarFilmesPopulares();
    }
    @GetMapping("/buscar/todos")
    public CardMultiBuscaDTO pesquisarFilmeSeriePessoa(@RequestParam String nome){
        return conexaoTmdbService.buscarCardFilmePessoaSerie(nome);
    }
    @GetMapping("/buscar/filme")
    public List<CardFilmeSerieDTO> pesquisarFilme(@RequestParam String nome){
        return conexaoTmdbService.buscarCardFilmeTmdb(nome);
    }
    @GetMapping("/buscar/serie")
    public List<CardFilmeSerieDTO> pesquisarSerie(@RequestParam String nome){
        return conexaoTmdbService.buscarCardSerieTmdb(nome);
    }
    @GetMapping("/buscar/pessoa")
    public List<CardPessoaDTO> pesquisarPessoa(@RequestParam String nome){
        return conexaoTmdbService.buscarCardPessoaTmdb(nome);
    }
    @GetMapping("/detalhar/filme/{idFilme}")
    public ExibirFilmeDTO detalharFilme(@PathVariable Long idFilme){
        return conexaoTmdbService.detalharFilme(idFilme);
    }
    @GetMapping("/detalhar/serie/{idSerie}")
    public List<CardPessoaDTO> detalharSerie(@PathVariable Long idSerie){
        return null;
    }
    @GetMapping("/detalhar/pessoa/{idPessoa}")
    public List<CardPessoaDTO> detalharPessoa(@PathVariable Long idPessoa){
        return null;
    }
}
