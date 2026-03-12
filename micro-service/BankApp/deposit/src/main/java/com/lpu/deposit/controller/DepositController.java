package com.lpu.deposit.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/deposit")
public class DepositController {
	
	@GetMapping("/dinfo")
	public String depositInfo() {
		System.err.println("hiiiiiiiiiiii");
		return "Deposit Service Running";
	}
	
}
