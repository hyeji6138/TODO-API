package com.example.todo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TodoRepository extends JpaRepository<TodoEntity, Long>, JpaSpecificationExecutor<TodoEntity> {
    default TodoEntity getById(Long id) {
        return findById(id).orElseThrow(() -> new IllegalArgumentException("Post not found"));
    }
}
