package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Book;
import com.revature.services.BookService;

@RestController
@RequestMapping("")
public class BookController {

	private BookService bookService;
	
	// or @Inject
	@Autowired
	public BookController(BookService bookService) {
		super();
		this.bookService = bookService;
	}
	
	

	@GetMapping("/{id}")
	public Book getBookById(@PathVariable int id) {
		return bookService.getBook(id);
	}
	
	@GetMapping("author/{authorId}")
	public List<Book> getBooksByAuthor(@PathVariable int authorId) {
		return bookService.getBooksByAuthor(authorId);
	}
	
	@GetMapping
	public Page<Book> getBookPage(Pageable page, @RequestParam Integer authorId) {
		if (authorId == null) {
			return bookService.getBooksPage(page);			
		} else {
			return bookService.getBooksByAuthor(authorId, page);
		}
		
	}
	
	@PostMapping
	public Book createBook(@RequestBody Book book) {
		return bookService.create(book);
	}
}
