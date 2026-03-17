package com.example.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;

import com.example.todo.dto.TodoDto;

@Service
public class TodoService {
	@Autowired
	private TodoRepository todoRepository;

	public boolean registerTodo(TodoDto todo) { // 할 일 생성
		TodoEntity newTodo = new TodoEntity(todo.getTitle(), todo.getContent(), todo.getStatus());
		todoRepository.save(newTodo);
		return true;
	}

	public Page<TodoDto> getTodoList(@PageableDefault(page = 0, size = 10) Pageable pageable) { // 할 일 목록 조회
		Page<TodoEntity> result = todoRepository.findAll(pageable);
		return result.map(TodoDto::from);
	}
}
