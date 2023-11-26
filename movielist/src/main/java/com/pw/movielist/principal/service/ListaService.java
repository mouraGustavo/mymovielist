package com.pw.movielist.principal.service;

import com.pw.movielist.principal.exception.NotFoundException;
import com.pw.movielist.principal.model.Item;
import com.pw.movielist.principal.model.Lista;
import com.pw.movielist.principal.model.Log;
import com.pw.movielist.principal.model.Usuario;
import com.pw.movielist.principal.model.dto.ItemDTO;
import com.pw.movielist.principal.model.dto.ListaDTO;
import com.pw.movielist.principal.repository.ItemRepository;
import com.pw.movielist.principal.repository.ListaRepository;
import com.pw.movielist.principal.repository.LogRepository;
import com.pw.movielist.principal.repository.UsuarioRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ListaService {

    private final ListaRepository listaRepository;

    private final UsuarioRepository usuarioRepository;

    private final ItemRepository itemRepository;

    private final LogRepository logRepository;

    private final ConexaoTmdbService conexaoTmdbService;

    public ListaService(ListaRepository listaRepository, UsuarioRepository usuarioRepository, ItemRepository itemRepository, LogRepository logRepository, ConexaoTmdbService conexaoTmdbService) {
        this.listaRepository = listaRepository;
        this.usuarioRepository = usuarioRepository;
        this.itemRepository = itemRepository;
        this.logRepository = logRepository;
        this.conexaoTmdbService = conexaoTmdbService;
    }

    public ListaDTO encontrarListaPeloId(Long id) throws NotFoundException {
        Optional<Lista> lista = listaRepository.findById(id);
        if(lista.isPresent())
            return new ListaDTO(lista.get());
        throw new NotFoundException("Lista não encontrada");
    }

    public List<ListaDTO> encontrarListaPeloUsuario(Long idUsuario){
        try{
            Optional<Usuario> usuario = usuarioRepository.findById(idUsuario);
            if(usuario.isPresent()){
                return usuario.get().getListas().stream().map(ListaDTO::new).toList();
            }
        }catch (Exception ignore){}
        throw new NotFoundException("Usuario com id " + idUsuario + " não encontrado");
    }

    public ResponseEntity<String> criarLista(ListaDTO listaRequest){
        try{
            Optional<Usuario> usuario = usuarioRepository.findById(listaRequest.getIdUsuario());
            if(usuario.isPresent()){
                Lista lista = new Lista(listaRequest.getNome(), usuario.get());
                if(listaRequest.getItens() != null)
                    lista.getListaItem().addAll(listaRequest.getItens().stream().map(Item::new).peek(item -> item.setPertenceA(lista)).toList());
                listaRepository.save(lista);
                return ResponseEntity.status(HttpStatus.OK).body("lista criada com sucesso!");
            }
        }catch (Exception ignore){}
        throw new NotFoundException("Usuario com id " + listaRequest.getIdUsuario() + " não encontrado");
    }

    public ResponseEntity<String> adicionarItensLista(List<ItemDTO> itensRequest, Long idLista) {
        Optional<Lista> lista = listaRepository.findById(idLista);
        if(lista.isPresent()) {
            var itens = itemRepository.saveAll(itensRequest.stream().map(Item::new).peek(item -> item.setPertenceA(lista.get())).toList());

            try{
                itens.forEach( item -> salvarLogCriacaoCard(new ItemDTO(item), item));
            } catch (Exception _ignore){}

            return ResponseEntity.status(HttpStatus.OK).body("Itens adicionados a lista " + idLista + " com sucesso!");
        }

        throw new NotFoundException("Lista " + idLista + " não encontrada");
    }
    public ResponseEntity<String> adicionarItemLista(ItemDTO itemRequest, Long idLista) {
        Optional<Lista> lista = listaRepository.findById(idLista);
        if(lista.isPresent()) {
            Item item = new Item(itemRequest);
            item.setPertenceA(lista.get());
            itemRepository.save(item);
            return ResponseEntity.status(HttpStatus.OK).body("Itens adicionados a lista " + idLista + " com sucesso!");
        }
        throw new NotFoundException("Lista " + idLista + " não encontrada");
    }

    public ResponseEntity<String> removerItens(List<Long> idItens, Long idLista) {
        Optional<Lista> lista = listaRepository.findById(idLista);
        if(lista.isPresent()){
            List<Item> itensExcluir = lista.get().getListaItem().stream().filter( item -> idItens.contains(item.getId())).toList();
            itensExcluir.forEach( item -> salvarLogExclusaoCard(new ItemDTO(item), item));
            lista.get().getListaItem().removeAll(itensExcluir);
            itemRepository.deleteAllById(idItens);
            return ResponseEntity.status(HttpStatus.OK).body("Itens removidos da lista " + idLista + " com sucesso!");
        }
        throw new NotFoundException("Lista " + idLista + " não encontrada");
    }

    public ResponseEntity<ItemDTO> editarItem(Long idItem, ItemDTO itemDTO) {
        Optional<Item> item = itemRepository.findById(idItem);
        if(item.isPresent()){
            salvarLogAtualizacaoCard(itemDTO, item.get());
            item.get().setAvaliacao(itemDTO.getAvaliacao().toString());
            item.get().setStatus(itemDTO.getStatus());
            item.get().setComentario(itemDTO.getComentario());
            Item itemAtualizado = itemRepository.save(item.get());
            return ResponseEntity.status(HttpStatus.OK).body(new ItemDTO(itemAtualizado));
        }
        throw new NotFoundException("Item " + idItem + " não encontrada");
    }

    public void salvarLogExclusaoCard(ItemDTO itemDTO, Item item){
        salvarLogGeral(itemDTO, item, "excluiu da lista "+ item.getPertenceA().getNome());
    }

    public void salvarLogCriacaoCard(ItemDTO itemDTO, Item item){
        salvarLogGeral(itemDTO, item, getAcaoStatus(itemDTO.getStatus()));
    }

    public void salvarLogAtualizacaoCard(ItemDTO itemDTO, Item item){
        salvarLogGeral(itemDTO, item, String.join(", ", getAcoes(itemDTO, item)));
    }

    public void salvarLogGeral(ItemDTO itemDTO, Item item, String acaoAcoes){
        Long idUsuario = item.getPertenceA().getUsuario().getId();
        Long idTmdb = Long.valueOf(item.getIdImdb());
        logRepository.save(new Log(idUsuario, acaoAcoes, idTmdb, new Date()));
    }

    private static List<String> getAcoes(ItemDTO itemDTO, Item item) {
        List<String> acoes = new ArrayList<>();

        if(!item.getAvaliacao().equals(itemDTO.getAvaliacao().toString()))
            acoes.add("mudou a nota de " + item.getAvaliacao() + " para " + itemDTO.getAvaliacao());
        if(!item.getStatus().equals(itemDTO.getStatus())){
            acoes.add(getAcaoStatus(itemDTO.getStatus()));
        }
        if(!item.getComentario().equals(itemDTO.getComentario())){
             acoes.add("mudou os comentarios");
        }
        return acoes;
    }

    public static String getAcaoStatus(String status){
        return switch (status) {
            case "assistindo" -> "está assistindo";
            case "dropado" -> "desistiu de assistir";
            case "completo" -> "terminou de assistir";
            default -> "planeja assistir";
        };
    }


    public ResponseEntity<String> editarLista(Long idLista, ListaDTO listaRequest) {
        Optional<Lista> lista = listaRepository.findById(idLista);
        if(lista.isPresent()){
            lista.get().setNome(listaRequest.getNome());
            if(listaRequest.getItens() != null)
                lista.get().getListaItem().addAll(listaRequest.getItens().stream().map(Item::new).peek(item -> item.setPertenceA(lista.get())).toList());
            listaRepository.save(lista.get());
            return ResponseEntity.status(HttpStatus.OK).body("lista atualizada com sucesso!");
        }
        throw new NotFoundException("Lista " + idLista + " não encontrada");
    }

    public ResponseEntity<String> excluirLista(Long idLista) {
        Optional<Lista> lista = listaRepository.findById(idLista);
        if(lista.isPresent()){
            listaRepository.delete(lista.get());
            return ResponseEntity.status(HttpStatus.OK).body("lista excluida!");
        }
        throw new NotFoundException("Lista " + idLista + " não encontrada");
    }
}
