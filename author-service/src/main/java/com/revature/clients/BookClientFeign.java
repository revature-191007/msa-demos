package com.revature.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.revature.dtos.BookDTO;

/**
 * Fiegn Client is an automatically implementing interface
 * that matches a foreign controller and implements the client
 * side of the controller logic such that requests to the foreign
 * controller can be called easily with the same syntax as already
 * exist in the controller.
 *
 */

@FeignClient("book-service")
@Profile("feignclient")
public interface BookClientFeign extends BookClient {
	
	@GetMapping("author/{authorId}")
	public List<BookDTO> getBooksByAuthorId(@PathVariable int authorId);
	
}
