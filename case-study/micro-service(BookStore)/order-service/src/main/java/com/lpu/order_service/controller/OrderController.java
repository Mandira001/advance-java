package com.lpu.order_service.controller;

import java.time.LocalDate;
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

import com.lpu.order_service.BookClient;
import com.lpu.order_service.entity.BookDTO;
import com.lpu.order_service.entity.Order;
import com.lpu.order_service.repository.OrderRepo;



@RequestMapping("/api/orders")
@RestController
public class OrderController {
	@Autowired
	private OrderRepo repo;
	
	@Autowired
	private BookClient feignClient;
	
	@GetMapping()
	public List<Order> allOrders(){
		return repo.findAll();
	}
	
	@GetMapping("/{id}")
	public Order findOrderById(@PathVariable Long id) {
		return repo.findById(id).orElse(null);
	}
	
	@PostMapping()
	public Order newOrder(@RequestBody Order order) {
		BookDTO book= feignClient.FetchById(order.getBookId());
		System.out.println("BOOK FROM FEIGN: " + book);
		Double total=book.getPrice()*order.getQuantity();
		order.setPrice(total);
		order.setStatus("PLACED");
		order.setOrderDate(LocalDate.now());
		
		return repo.save(order);
		
	}
	
	@PutMapping("/{id}")
	public Order updateOrder(@PathVariable Long id, @RequestBody Order order) {
		Order orders = repo.findById(id).orElseThrow();

	    order.setStatus(order.getStatus());
		return repo.save(orders);
	}
	
	@DeleteMapping("/{id}")
	public void deleteOrder(@PathVariable Long id) {
		 repo.deleteById(id);
	}
	
	//FEIGN CLIENT
	
	@GetMapping("/findbook/{id}")
	public BookDTO findBookByOrder(@PathVariable Long id) {
		return feignClient.FetchById(id);
	}
	
	@GetMapping("/getbooks")
	public List<BookDTO> getAllBooks() {
		return feignClient.fetchBook();
	}
	
	@PostMapping("/savebook")
	public BookDTO saveBook(@RequestBody BookDTO book) {
		return feignClient.saveBook(book);
	}
	
	@PutMapping("/updatebook/{id}")
	public BookDTO updateBook(  @RequestBody BookDTO book, @PathVariable Long id) {
		return feignClient.updateBook( book, id);
	}
	
	@DeleteMapping("/deletebook/{id}")
	public String deleteBook(@PathVariable Long id) {
		 feignClient.deleteBook(id);
		 return "book deleted";
	}
}
