package com.andyholes.graphqldemo.repository;

import com.andyholes.graphqldemo.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
