package com.lpu.Payment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.lpu.Payment.entity.Payment;
import com.lpu.Payment.repo.PaymentRepo;

@RestController
@RequestMapping("/payment")
public class PaymentController {
	@Autowired
    private PaymentRepo repo;

    @PostMapping("/pay")
    public Payment makePayment(@RequestBody Payment payment) {
        return repo.save(payment);
    }

    @GetMapping("/test")
    public String test() {
        return "Payment Service Working";
    }
    
    @GetMapping("/rt")
    public ResponseEntity<String> takeDataFromUserService(){
    	String url = "http://localhost:8081/user/data";
    	RestTemplate template = new RestTemplate();
    	ResponseEntity<String> response = template.exchange(url, HttpMethod.GET, null, String.class);
    	return response;
    }
    
    @GetMapping("/rt/{id}")
    public ResponseEntity<String> takeDataFromUser(@PathVariable int id){
    	String url = "http://localhost:8081/user/{id}";
    	RestTemplate template = new RestTemplate();
    	ResponseEntity<String> response = template.exchange(url, HttpMethod.GET, null, String.class, id);
    	return response;
    }
}
