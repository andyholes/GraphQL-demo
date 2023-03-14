package com.andyholes.graphqldemo.controller;

import com.andyholes.graphqldemo.model.Book;
import com.andyholes.graphqldemo.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class BookController {
        private final BookRepository bookRepository;
        @QueryMapping
        Iterable<Book> books(){
            return bookRepository.findAll();
        }
    }
