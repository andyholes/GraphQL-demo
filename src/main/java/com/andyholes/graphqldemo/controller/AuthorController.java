package com.andyholes.graphqldemo.controller;

import com.andyholes.graphqldemo.model.Author;
import com.andyholes.graphqldemo.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorRepository authorRepository;
    @QueryMapping //if method name differs from the one defined in the schema i can use (name="authors")
    Iterable<Author> authors(){
        return authorRepository.findAll();
    }

    @QueryMapping
    Optional<Author> authorById(@Argument Long id){
        return authorRepository.findById(id);
    }
}
