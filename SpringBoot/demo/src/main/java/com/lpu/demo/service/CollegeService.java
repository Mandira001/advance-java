package com.lpu.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lpu.demo.entity.College;
import com.lpu.demo.entity.Student;
import com.lpu.demo.repository.CollegeRepository;

@Service
public class CollegeService {
	@Autowired
	private CollegeRepository repository;
}
