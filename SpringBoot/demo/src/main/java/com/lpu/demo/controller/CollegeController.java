package com.lpu.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.lpu.demo.service.CollegeService;

@RestController
public class CollegeController {
	@Autowired
	private CollegeService service;
	
	
}
