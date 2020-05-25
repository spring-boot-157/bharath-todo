package com.bharath.webservices.rest.todo.controller;

import java.util.List;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
import com.bharath.webservices.rest.todo.model.Todo;

@RestController
@CrossOrigin(origins = "http://localhost:4200")


public class TodoController {
	
	@Autowired
	private TodoService todoService;
	
	@Autowired
	private AmqpTemplate rabbitTemplate;

 

	@GetMapping("/users/{name}/todos")
	public ResponseEntity<List<Todo>> getTodos(@PathVariable String name) {
		return   ResponseEntity.ok(todoService.getTodos(name)); 
	}
	
	@DeleteMapping("/users/{name}/todos/{Id}")
	public ResponseEntity<Void> deleteTodos(@PathVariable String name, @PathVariable int Id) {
		todoService.deleteTodos(name, Id);
		return   ResponseEntity.noContent().build();
	}
	
	@GetMapping("/todo/{id}")
	public ResponseEntity<Todo> getTodo(@PathVariable int id) {
		return   ResponseEntity.ok(todoService.getTodo(id)); 
	}
	
	@PutMapping("/users/{name}/todos/{Id}")
	public ResponseEntity<Void> updateTodo(@PathVariable String name,@PathVariable int Id,@RequestBody Todo todo) {
		System.out.println("todo- user-..-.--."+todo.getUser());
		todoService.save(name,todo);
		return   ResponseEntity.noContent().build();
	}
	
	@PostMapping("/users/{name}/todos")
	public ResponseEntity<Void> createTodo(@PathVariable String name, @RequestBody Todo todo) {
		todoService.save(name, todo);
		return   ResponseEntity.noContent().build();
	}
	
	@PostMapping(path = "/customer/{queue}/{message}")
	public ResponseEntity<String> sendMessage(@PathVariable("message")   String message, @PathVariable("queue") String queue) throws Exception {

		rabbitTemplate.convertAndSend(queue, message);
	     
	      
		return new ResponseEntity<String>(message, HttpStatus.OK);
	}
	
	@RabbitListener(queues = "test-Queue")
	public void receiveMessage(String message) {
	    System.out.println("Received   message: " + message);
	}
	 
	
}
