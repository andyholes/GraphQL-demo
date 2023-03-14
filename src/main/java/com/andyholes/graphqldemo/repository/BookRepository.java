package com.andyholes.graphqldemo.repository;

import com.andyholes.graphqldemo.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
