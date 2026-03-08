package com.lpu.demo_security1.DemoController;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

	@RequestMapping("/hi")
	public String sayHi(String str) {
		return "hiiiii";
	}
	
	@RequestMapping("/home")
	public String homepage(String str) {
		return "Home Page";
	}
	
	@RequestMapping("/reg")
	public String registerPage(String str) {
		return "registration page";
	}
}
