package com.bharath.webservices.rest.todo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bharath.webservices.rest.todo.Service.TodoService;
import com.bharath.webservices.rest.todo.model.AuthBean;
import com.bharath.webservices.rest.todo.model.Todo;

@RestController
@CrossOrigin(origins = "http://localhost:4200")


public class AuthController {
	
	@Autowired
	private TodoService todoService;

	@GetMapping("/auth")
	public ResponseEntity<AuthBean> getTodos() {
		return   ResponseEntity.ok(new AuthBean()); 
	}
	 
}
