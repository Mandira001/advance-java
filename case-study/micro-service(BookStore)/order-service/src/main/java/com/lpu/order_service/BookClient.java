package com.lpu.order_service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.lpu.order_service.entity.BookDTO;

@FeignClient(name = "book-service")
public interface BookClient {
	
	@PostMapping("/api/book")
	public BookDTO saveBook(@RequestBody BookDTO book);
	
	@GetMapping("/api/book")
	public List<BookDTO> fetchBook();
	
	@GetMapping("/api/book/{id}")
	public BookDTO FetchById(@PathVariable long id);
	
	@PutMapping("/api/book/{id}")
	public BookDTO updateBook(@RequestBody BookDTO book, @PathVariable long id);
	
	@DeleteMapping("/api/book/{id}")
	public String deleteBook(@PathVariable long id);
}
