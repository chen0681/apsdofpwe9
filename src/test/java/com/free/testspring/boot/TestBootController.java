package com.free.testspring.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/boot")
@SpringBootApplication 
public class TestBootController {

	@RequestMapping("test1")
	public String  test1() {
		return "test1";
	}
	
	public static void main(String[] args) {
		SpringApplication.run(TestBootController.class);
	}
}
