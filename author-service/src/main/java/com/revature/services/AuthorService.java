package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import com.revature.clients.BookClient;
import com.revature.dtos.BookDTO;
import com.revature.models.Author;
import com.revature.repositories.AuthorRepository;

@Service
public class AuthorService {

	@Autowired
	AuthorRepository authorRepository;
	
	@Autowired
	BookClient bookClient;
	
	public Author getById(int id) {
		Author author = authorRepository.findById(id)
				.orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
		
		List<BookDTO> books = bookClient.getBooksByAuthorId(author.getId());
		
		author.setBooks(books);
		
		return author;
	}

	public Page<Author> getPage(Pageable page) {
		return authorRepository.findAll(page);
	}

	public Author create(Author author) {
		return authorRepository.save(author);
	}

}
