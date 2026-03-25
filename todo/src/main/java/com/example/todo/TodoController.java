package com.example.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

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
            boolean result = todoService.registerTodo(todo);
            response = new ResponseDto("success", result);
        } catch (Exception e) {
            response = new ResponseDto("fail", e.getMessage());
        }
		return response;
	}

    @GetMapping("/todo")
    public ResponseDto<Page<TodoDto>> getTodoList(@PageableDefault(page=0, size=10) Pageable pageable) {
        ResponseDto<Page<TodoDto>> response = null;
        try {
            Page<TodoDto> result = todoService.getTodoList(pageable);
            response = new ResponseDto("success", result);
        } catch (Exception e) {
            response = new ResponseDto("fail", e.getMessage());
        }
        return response;
    }

    @GetMapping("/todo/{id}")
    public ResponseDto<TodoDto> getTodoDetail(@PathVariable("id") Long id) {
        ResponseDto<TodoDto> response = null;
        try {
            TodoDto result = todoService.getTodoDetail(id);
            response = new ResponseDto("success", result);
        } catch (Exception e) {
            response = new ResponseDto("fail", e.getMessage());
        }
        return response;
    }

    @PutMapping("/todo/{id}")
    public ResponseDto<TodoDto> updateTodo(@PathVariable("id") Long id, @RequestBody TodoDto todo){
        ResponseDto<TodoDto> response = null;
        try {
            TodoDto result = todoService.updateTodo(id, todo);
            response = new ResponseDto("success", result);
        } catch (Exception e) {
            response = new ResponseDto("fail", e.getMessage());
        }
        return response;
    }

    @PatchMapping("/todo/{id}/status")
    public ResponseDto<TodoDto> updateStatus(@PathVariable("id") Long id, @RequestBody int status){
        ResponseDto<TodoDto> response = null;
        try {
            TodoDto result = todoService.updateStatus(id, status);
            response = new ResponseDto("success", result);
        } catch (Exception e) {
            response = new ResponseDto("fail", e.getMessage());
        }
        return response;
    }

    @DeleteMapping("/todo/{id}")
    public ResponseDto<Boolean> deleteTodo(@PathVariable("id") Long id){
        ResponseDto<Boolean> response = null;
        try {
            boolean result = todoService.deleteTodo(id);
            response = new ResponseDto("success", result);
        } catch (Exception e) {
            response = new ResponseDto("fail", e.getMessage());
        }
        return response;
    }
}
