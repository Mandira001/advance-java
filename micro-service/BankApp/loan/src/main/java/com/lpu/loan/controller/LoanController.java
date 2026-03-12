package com.lpu.loan.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/loan")
public class LoanController {
	
	@GetMapping("/info")
	public String loanInfo() {
		return "Loan Service Running";
	}
}
