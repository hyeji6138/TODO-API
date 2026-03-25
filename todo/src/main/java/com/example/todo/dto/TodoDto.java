package com.example.todo.dto;

import java.time.LocalDateTime;

import com.example.todo.TodoEntity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
public class TodoDto {
	@Schema(description="할 일 번호")
	private Long id;
	@Schema(description="할 일 제목")
	private String title;
	@Schema(description="할 일 내용")
	private String content;
	@Schema(description="할 일 상태")
	private int status;
	@Schema(description="할 일 생성 시간")
	private LocalDateTime createdAt;
	@Schema(description="할 일 수정 시간")
	private LocalDateTime updatedAt;
	
	@Builder
    public TodoDto(Long id, String title, String content, int status, LocalDateTime createdAt, LocalDateTime updatedAt){
        this.id = id;
        this.title = title;
        this.content = content;
        this.status = status;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public static TodoDto from(TodoEntity entity){
        return TodoDto.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .content(entity.getContent())
                .status(entity.getStatus())
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt()).build();
    }
}
