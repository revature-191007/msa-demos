package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import com.revature.models.Book;
import com.revature.repositories.BookRepository;

//@Profile("dev") // Used to denote a bean is only used in specific profiles
@Service
public class BookService {

	BookRepository bookRepository;
	
	@Autowired
	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	public Book getBook(int id) {
		return this.bookRepository.findById(id)
			.orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
	}

	public Page<Book> getBooksPage(Pageable page) {
		return this.bookRepository.findAll(page);
	}

	public Book create(Book book) {
		return this.bookRepository.save(book);
	}

	public Page<Book> getBooksByAuthor(Integer authorId, Pageable page) {
		return this.bookRepository.getBooksByAuthorId(authorId, page);
	}
	
	public List<Book> getBooksByAuthor(int authorId) {
		return this.bookRepository.getBooksByAuthorId(authorId);
	}

}
