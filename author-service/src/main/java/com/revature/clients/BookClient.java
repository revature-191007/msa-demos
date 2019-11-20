package com.revature.clients;

import java.util.List;

import com.revature.dtos.BookDTO;

public interface BookClient {
	List<BookDTO> getBooksByAuthorId(int authorId);
}
