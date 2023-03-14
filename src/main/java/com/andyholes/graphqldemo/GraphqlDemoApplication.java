package com.andyholes.graphqldemo;

import com.andyholes.graphqldemo.model.Author;
import com.andyholes.graphqldemo.model.Book;
import com.andyholes.graphqldemo.repository.AuthorRepository;
import com.andyholes.graphqldemo.repository.BookRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class GraphqlDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(GraphqlDemoApplication.class, args);
	}

	@Bean
	ApplicationRunner applicationRunner(AuthorRepository authorRepository, BookRepository bookRepository){
		return args ->{
			Author author1 = authorRepository.save(new Author(null,"Andy",27,null));
			Author author2 = authorRepository.save(new Author(null,"Holes",22,null));
			bookRepository.saveAll(List.of(
					new Book(null,"The new book","A book",true,authorRepository.getReferenceById(1L)),
					new Book(null,"The other","The second book",false,authorRepository.getReferenceById(2L))
			));
		};
	}
}
