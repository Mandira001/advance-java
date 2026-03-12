package com.lpu.book_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lpu.book_service.entity.Book;
import com.lpu.book_service.repository.BookRepo;

@RestController
@RequestMapping("/api/book")
public class BookController {
	@Autowired
	private BookRepo repo;
	
	@PostMapping()
	public Book saveBook(@RequestBody Book book) {
		return repo.save(book);
	}
	
	@GetMapping()
	public List<Book> fetchBook() {
		return repo.findAll();
	}
	
	@GetMapping("/{id}")
	public Book FetchById(@PathVariable long id) {
		return repo.findById(id).orElse(null);
	}
	
	@PutMapping("/{id}")
	public Book updateBook(@RequestBody Book book, @PathVariable long id) {
		book.setId(id);
		return repo.save(book);
	}
	
	@DeleteMapping("/{id}")
	public String deleteBook(@PathVariable long id) {
		repo.deleteById(id);
		return "Book deleted";
	}
}
