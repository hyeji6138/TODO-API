package com.example.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.todo.dto.ResponseDto;
import com.example.todo.dto.TodoDto;

@RestController
public class TodoController {
	@Autowired
	private TodoService todoService;

	@GetMapping("/")
	public String HelloWorld() {
		return "hello world!";
	}

	@PostMapping("/todo")
	public ResponseDto<Boolean> registerTodo(@RequestBody TodoDto todo) {
		ResponseDto<Boolean> response = null;
		try {
            boolean status = todoService.registerTodo(todo);
            response = new ResponseDto("success", status);
        } catch (Exception e) {
            response = new ResponseDto("fail", e.getMessage());
        }
		return response;
	}
}
