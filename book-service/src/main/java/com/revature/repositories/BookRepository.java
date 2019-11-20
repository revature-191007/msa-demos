package com.revature.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

	Page<Book> getBooksByAuthorId(Integer authorId, Pageable page);
	List<Book> getBooksByAuthorId(int authorId);

}
