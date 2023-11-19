package com.pw.movielist.principal.controller;

import com.pw.movielist.principal.model.dto.ItemDTO;
import com.pw.movielist.principal.model.dto.ListaDTO;
import com.pw.movielist.principal.service.ListaService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("lista")
public class ListaController {
    //TODO: Implementar sessionId para que somente os usuarios autorizados possam modificar a lista
    private final ListaService listaService;

    public ListaController(ListaService listaService) {
        this.listaService = listaService;
    }

    @PostMapping("")
    @Operation(summary = "Cria uma lista nova")
    public ResponseEntity<String> criarLista(@RequestBody ListaDTO lista, @RequestParam String sessionId){
        return listaService.criarLista(lista);
    }

    @GetMapping("/{idLista}")
    @Operation(summary = "Visualiza uma lista")
    public ListaDTO visualizarLista(@PathVariable Long idLista){
        return listaService.encontrarListaPeloId(idLista);
    }

    @PostMapping("/{idLista}")
    @Operation(summary = "Editar uma lista")
    public ResponseEntity<String> editarLista(@PathVariable Long idLista, @RequestBody ListaDTO lista, @RequestParam String sessionId){
        return listaService.editarLista(idLista, lista);
    }
    @DeleteMapping("/{idLista}")
    @Operation(summary = "Excluir uma lista")
    public ResponseEntity<String> excluirLista(@PathVariable Long idLista, @RequestParam String sessionId){
        return listaService.excluirLista(idLista);
    }

    @PostMapping("/{idLista}/adicionar_item")
    @Operation(summary = "Adicionar itens a uma lista")
    public ResponseEntity<String> adicionarItens(@PathVariable Long idLista, @RequestBody List<ItemDTO> itens, @RequestParam String sessionId){
        return listaService.adicionarItensLista(itens, idLista);
    }

    @PostMapping("/{idLista}/remover_item")
    @Operation(summary = "Remover itens de uma lista")
    public ResponseEntity<String> removerItens(@PathVariable Long idLista, @RequestBody List<Long> idItens, @RequestParam String sessionId){
        return listaService.removerItens(idItens, idLista);
    }
}
