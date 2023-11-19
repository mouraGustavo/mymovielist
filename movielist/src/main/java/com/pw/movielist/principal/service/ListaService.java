package com.pw.movielist.principal.service;

import com.pw.movielist.principal.exception.NotFoundException;
import com.pw.movielist.principal.model.Item;
import com.pw.movielist.principal.model.Lista;
import com.pw.movielist.principal.model.Usuario;
import com.pw.movielist.principal.model.dto.ItemDTO;
import com.pw.movielist.principal.model.dto.ListaDTO;
import com.pw.movielist.principal.repository.ItemRepository;
import com.pw.movielist.principal.repository.ListaRepository;
import com.pw.movielist.principal.repository.UsuarioRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ListaService {

    private final ListaRepository listaRepository;

    private final UsuarioRepository usuarioRepository;

    private final ItemRepository itemRepository;

    public ListaService(ListaRepository listaRepository, UsuarioRepository usuarioRepository, ItemRepository itemRepository) {
        this.listaRepository = listaRepository;
        this.usuarioRepository = usuarioRepository;
        this.itemRepository = itemRepository;
    }

    public ListaDTO encontrarListaPeloId(Long id) throws NotFoundException {
        Optional<Lista> lista = listaRepository.findById(id);
        if(lista.isPresent())
            return new ListaDTO(lista.get());
        throw new NotFoundException("Lista não encontrada");
    }

    public ResponseEntity<String> criarLista(ListaDTO listaRequest){
        Optional<Usuario> usuario = usuarioRepository.findById(listaRequest.getIdUsuario());
        if(usuario.isPresent()){
            Lista lista = new Lista(listaRequest.getNome(), usuario.get());
            if(listaRequest.getItens() != null)
                lista.getListaItem().addAll(listaRequest.getItens().stream().map(Item::new).peek(item -> item.setPertenceA(lista)).toList());
            listaRepository.save(lista);
            return ResponseEntity.status(HttpStatus.OK).body("lista criada com sucesso!");
        }
        throw new NotFoundException("Usuario com id " + listaRequest.getIdUsuario() + " não encontrado");
    }

    public ResponseEntity<String> adicionarItensLista(List<ItemDTO> itensRequest, Long idLista) {
        Optional<Lista> lista = listaRepository.findById(idLista);
        if(lista.isPresent()) {
            itemRepository.saveAll(itensRequest.stream().map(Item::new).peek(item -> item.setPertenceA(lista.get())).toList());
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
            itemRepository.deleteAllById(idItens);
            return ResponseEntity.status(HttpStatus.OK).body("Itens removidos da lista " + idLista + " com sucesso!");
        }
        throw new NotFoundException("Lista " + idLista + " não encontrada");
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
