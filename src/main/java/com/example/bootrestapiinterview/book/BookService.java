package com.example.bootrestapiinterview.book;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookService {
	
	private final BookRepository bookRepository;
	
	@Autowired
	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
	
	public List<Book> getBooks() {
		
		return bookRepository.findAll();
	}

	public void addNewBook(Book book) {		
		
		bookRepository.save(book);
		
	}

	public void deleteBook(Long bookId) {
		// TODO Auto-generated method stub
		boolean exists = bookRepository.existsById(bookId);
		
		if(!exists) {
			throw new IllegalStateException("Book with ID "+ bookId + "does not exist");
		}
		bookRepository.deleteById(bookId);
		
		
		
	}

	@Transactional
	public void updateBook(Long bookId, String name, String status) {
		// TODO Auto-generated method stub
		Book book = bookRepository.findById(bookId)
				.orElseThrow(() -> new IllegalStateException(
						"Book with id "+ bookId + " does not exist"));
		
		if(name != null &&
				name.length() > 0 &&
				!Objects.equals(book.getName(), name)) {
			book.setName(name);
		}
		
		if(status != null &&
				status.length() > 0 &&
				!Objects.equals(book.getStatus(), status)) {
			Optional<Book> studentOptional = bookRepository.findBookByStatus(status);
			if (studentOptional.isPresent()) {
				throw new IllegalStateException("email taken");
			}
			 book.setStatus(status);
		}
		
	}

	public Optional<Book> getBookById(Long id) {
		//bookRepository.getById(id);
		return bookRepository.findById(id);
	}
	

}
