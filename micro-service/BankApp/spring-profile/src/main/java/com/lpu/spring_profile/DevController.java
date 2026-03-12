package com.lpu.spring_profile;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DevController {
	@Value("${server.port}")
	private String port;
	@Value("${user.name2}")
	private String name2;
	@Value("${user.name}")
	private String name;
	
	@GetMapping("/hi")
	public String sayHiToDevb() {
		System.err.println(port);
		System.err.println(name2);
		System.err.println(name);
		return "hii";
		
	}
}
