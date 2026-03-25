package com.example.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.example.todo.dto.TodoDto;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;

import javax.swing.text.html.parser.Entity;

@Service
public class TodoService {
	@Autowired
	private TodoRepository todoRepository;

	public boolean registerTodo(TodoDto todo) { // 할 일 생성
		TodoEntity newTodo = new TodoEntity(todo.getTitle(), todo.getContent(), todo.getStatus());
		todoRepository.save(newTodo);
		return true;
	}

	public Page<TodoDto> getTodoList(Pageable pageable) { // 할 일 목록 조회
		Page<TodoEntity> result = todoRepository.findAll(pageable);
		return result.map(TodoDto::from);
	}

    public TodoDto getTodoDetail(Long id) { // 할 일 목록 조회
        TodoEntity result = todoRepository.getById(id);
        return TodoDto.from(result);
    }

    @Transactional
    public TodoDto updateTodo(Long id, TodoDto todo){
        TodoEntity findedTodo = todoRepository.getById(id);
        findedTodo.update(todo.getTitle(), todo.getContent(), todo.getStatus());
        return TodoDto.from(findedTodo);
    }

    @Transactional
    public TodoDto updateStatus(Long id, int status){
        TodoEntity findedTodo = todoRepository.getById(id);
        findedTodo.update(status);
        return TodoDto.from(findedTodo);
    }

    public boolean deleteTodo(Long id){
        todoRepository.deleteById(id);
        return true;
    }
}
