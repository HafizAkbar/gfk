package com.example.bootrestapiinterview.book;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path = "api/v1/book")
public class BookContoller {
	
	private final BookService bookService ;
	
	@Autowired
	public BookContoller(BookService bookService) {
		this.bookService = bookService;
		// TODO Auto-generated constructor stub
	}

	@GetMapping
	public List<Book> getBooks() {
		return bookService.getBooks();
	}
	
	@GetMapping(path = "bookId")
	public Optional<Book> getBook() {
		long x = 1;
		return bookService.getBookById(x);
	}
	
	@PostMapping
	public void registerNewBook(@RequestBody Book book) {
		bookService.addNewBook(book);
	}
	
	@DeleteMapping(path = "{booktId}")
	public void deleteStudent(@PathVariable("bookId") Long bookId) {
		bookService.deleteBook(bookId);
	}
	
	@PutMapping(path = "{bookId}")
	public void updateBook(
			@PathVariable("bookId") Long bookId,
			@RequestParam(required = false) String name,
			@RequestParam(required = false) String status) {
		bookService.updateBook(bookId,name,status);
	}
	
}