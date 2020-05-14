package com.bharath.webservices.rest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")


public class HelloworldController {

	@GetMapping("/helloworld/{name}")
	public HelloworldBean helloworld(@PathVariable String name) {
		return new HelloworldBean(String.format("Hello %s", name));
	}
}
