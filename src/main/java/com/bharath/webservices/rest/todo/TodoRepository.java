package com.bharath.webservices.rest.todo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bharath.webservices.rest.todo.model.Todo;

@Repository

public interface TodoRepository extends JpaRepository<Todo,Long> {
	
	List<Todo> findByUser(String user);
	Todo findById(long id);
	 

}
