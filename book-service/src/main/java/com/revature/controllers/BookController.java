package com.revature.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
	
	@GetMapping
	public Page<Book> getBookPage(Pageable page) {
		return bookService.getBooksPage(page);
	}
	
	@PostMapping
	public Book createBook(@RequestBody Book book) {
		return bookService.create(book);
	}
}
