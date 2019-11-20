package com.revature.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

}
