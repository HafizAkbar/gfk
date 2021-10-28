package com.example.bootrestapiinterview.book;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class BookConfig {
	
	
	@Bean
	CommandLineRunner commandLineRunner(BookRepository repository) {
		return args ->{
			
			Book a = new Book("Book 1","AVAILABLE");
			Book b = new Book("Book 2","AVAILABLE");
			
			List<Book> books = new ArrayList<Book>(); 

			books.add(a);
			books.add(b);
			repository.saveAll(books);
		};
	}

}
