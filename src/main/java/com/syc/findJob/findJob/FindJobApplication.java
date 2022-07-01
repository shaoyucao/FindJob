package com.syc.findJob.findJob;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class FindJobApplication {

	public static void main(String[] args) {
		SpringApplication.run(FindJobApplication.class, args);
	}

	@RequestMapping("/Hello")
	public String sayHello() {
		return "Hello";
	}

}
