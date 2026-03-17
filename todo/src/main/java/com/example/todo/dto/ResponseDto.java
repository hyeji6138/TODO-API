package com.example.todo.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDto<T> {
	@Schema(description="반환 메세지")
	private String message;
	@Schema(description="반환 데이터")
	private T data;
}
