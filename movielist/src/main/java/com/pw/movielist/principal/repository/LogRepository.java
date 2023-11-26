package com.pw.movielist.principal.repository;

import com.pw.movielist.principal.model.Log;
import com.pw.movielist.principal.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LogRepository extends JpaRepository<Log, Long> {
    List<Log> findByIdUsuario(Long idUsuario);

}
