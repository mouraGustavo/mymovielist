package com.pw.movielist.principal.repository;

import com.pw.movielist.principal.model.Lista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListaRepository extends JpaRepository<Lista, Long>{
}
