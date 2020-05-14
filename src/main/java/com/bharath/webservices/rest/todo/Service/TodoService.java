package com.bharath.webservices.rest.todo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.bharath.webservices.rest.todo.TodoRepository;
import com.bharath.webservices.rest.todo.model.Todo;

@Service
@Component
public class TodoService {


	@Autowired
	private   TodoRepository todorepo;

	public List<Todo> getTodos(String name) {

		return  todorepo.findByUser(name);
	}
	
	public void  deleteTodos(String name,long id) {

		System.out.println("name and id-----"+name+"---"+id);
		todorepo.delete(todorepo.findById(id));
 	}
	
	public Todo getTodo(int id) {

		return todorepo.findById(id);
	}
	
	public void save(@PathVariable String name,Todo todo) {
		
		todorepo.save(todo);
		
	}
	
	
}
