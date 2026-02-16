package com.lpu;

import org.springframework.stereotype.Component;

@Component(value = "myStudent") //pass bean id
public class Student {
	public void study() {
		System.out.println("sleeping");
	}
}
