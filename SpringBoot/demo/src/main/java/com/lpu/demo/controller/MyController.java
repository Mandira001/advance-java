package com.lpu.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lpu.demo.entity.Student;

@RestController
public class MyController {
	
	//MethodType--GET
	//http://localhost:8080/hi
	@GetMapping("/hi")
	public String takeReq() {
		return "Byeee";
		}
	
	
	//////////////RequestParam//////////////////////
	//MethodType--GET
	//URL--http://localhost:8080/takeData?id=108&name=Raju
	@GetMapping("/takeData")
	public String takeData(@RequestParam int id, @RequestParam String name) {
		return "ID="+id+" NAME="+name;
		}
	
	//MethodType--GET
	//URL--http://localhost:8080/takeData?id=108&name=Raju&loc=Jaipur
	@GetMapping("/college")
	public String college(@RequestParam int id, @RequestParam String name, @RequestParam String loc) {
		return "ID="+id+" NAME="+name+" LOCATION="+loc;
		}
	
	////////////////Path Variable/////////////////////
	//MethodType--GET
	//URL--http://localhost:8080/takeData2/108/Raju
	@GetMapping("/takeData2/{id}/{name}")  //this variable name
	public String takeData2(@PathVariable int id, @PathVariable String name) {  //and this variable name should be same
		return "ID="+id+" Name="+name;
		}
	
	/////////////////////taking 2 URLs//////////////////
	//MethodType--GET
	//URL--http://localhost:8080/student/55/college/88
	@GetMapping("/student/{sId}/college/{cId}")
	public String takeData3(@PathVariable int sId, @PathVariable int cId) {
		return "StudentID="+sId+" CollegeID="+cId;
		}
	
	//////////////comparing both///////////////
	//MethodType--GET
	//URL--http://localhost:8080/takeData4/Raju?id=55
	@GetMapping("/takeData4/{name}")
	public String takeData4(@RequestParam int id, @PathVariable String name) {
		return "ID="+id+" NAME="+name;
	}
	
	/////////////////take data from header//////////////
	//http://localhost:8080/takeData5
	//inside header, key = id, value = 55
	//inside header, key = name, value = Mandira
	@GetMapping("/takeData5")
	public String takeData5(@RequestHeader int id, @RequestHeader String name) {
		return "ID="+id+" Name="+name;
	}
	
	@GetMapping("/student")
	public String getStudent(@RequestBody Student s) {
		System.out.println(s.getId());
		System.out.println(s.getName());
		System.out.println(s.getPhone());
		
		return s.getName()+" is recieved";
	}
	
	@GetMapping("/student2")
	public Student getStudent2(@RequestBody Student s) {
		return s;
	}
}
