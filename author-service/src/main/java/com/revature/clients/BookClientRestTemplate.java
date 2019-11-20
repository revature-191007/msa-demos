package com.revature.clients;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.revature.dtos.BookDTO;

@Component
@Profile("resttemplate")
public class BookClientRestTemplate implements BookClient {

	@Override
	public List<BookDTO> getBooksByAuthorId(int authorId) {
		// RestTemplate are a class used to send Http requests from your server
		RestTemplate template = new RestTemplate();
		String url = "http://localhost:8080/books/author/" + authorId;
		BookDTO[] bookArr = template.getForObject(url, BookDTO[].class);
		return Arrays.asList(bookArr);
	}
}
