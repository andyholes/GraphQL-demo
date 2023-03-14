package com.andyholes.graphqldemo.controller;

import com.andyholes.graphqldemo.model.Author;
import com.andyholes.graphqldemo.model.Book;
import com.andyholes.graphqldemo.repository.AuthorRepository;
import com.andyholes.graphqldemo.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class GraphqlController {

    private final AuthorRepository authorRepository;

    private final BookRepository bookRepository;

    @QueryMapping //if method name differs from the one defined in the schema i can use (name="authors")
    Iterable<Author> authors(){
        return authorRepository.findAll();
    }

    @QueryMapping
    Optional<Author> authorById(@Argument Long id){
        return authorRepository.findById(id);
    }

    @QueryMapping
    Iterable<Book> books(){
        return bookRepository.findAll();
    }

    @MutationMapping
    Book addBook(@Argument BookInput book){
        Author author = authorRepository.findById(book.authorId()).orElseThrow(()-> new IllegalArgumentException("Author not found by given ID"));
        return bookRepository.save(Book.builder()
                .title(book.title())
                .description(book.description())
                .published(book.published())
                .author(author)
                .build()
                );
    }
    record BookInput (String title, String description, boolean published, Long authorId){}
}
