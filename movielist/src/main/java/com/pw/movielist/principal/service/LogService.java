package com.pw.movielist.principal.service;

import com.pw.movielist.principal.exception.NotFoundException;
import com.pw.movielist.principal.model.Lista;
import com.pw.movielist.principal.model.Log;
import com.pw.movielist.principal.model.Usuario;
import com.pw.movielist.principal.model.dto.ListaDTO;
import com.pw.movielist.principal.repository.LogRepository;
import com.pw.movielist.principal.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LogService {

    private final LogRepository logRepository;

    private final UsuarioRepository usuarioRepository;

    public LogService(LogRepository logRepository, UsuarioRepository usuarioRepository) {
        this.logRepository = logRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public Log encontrarLog(Long idLog) {
        Optional<Log> log = logRepository.findById(idLog);
        if(log.isPresent())
            return log.get();
        throw new NotFoundException("Log não encontrada");
    }

    public List<Log> encontrarLogsUsuario(Long idUsuario) {
        Optional<Usuario> usuario = usuarioRepository.findById(idUsuario);
        if(usuario.isPresent()){
            return logRepository.findByIdUsuario(idUsuario);
        }
        throw new NotFoundException("Usuario não encontrada");
    }
}
