package com.pw.movielist.principal.repository;

import com.pw.movielist.principal.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
