package com.example.todo;

import java.time.LocalDateTime;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name="TODO")
public class TodoEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Schema(description="할 일 번호")
	private Long id;
	
	@Schema(description="할 일 제목")
	private String title;
	
	@Lob
	@Schema(description="할 일 내용")
	private String content;
	
	@Schema(description="할 일 상태")
	private int status;
	
	@Schema(description="할 일 생성 시간")
	private LocalDateTime createdAt;
	
	@Schema(description="할 일 수정 시간")
	private LocalDateTime updatedAt;
	
	public TodoEntity(String title, String content) {
		this.title = title;
		this.content = content;
	}
	public TodoEntity(String title, String content, int status) {
		this.title = title;
		this.content = content;
		this.status = status;
	}

    public void update(int status){
        this.status = status;
    }

    public void update(String title, String content, int status){
        this.title = title;
        this.content = content;
        this.status = status;
    }
	
	@PrePersist
	public void onCreate() { // 생성 시
        this.createdAt = LocalDateTime.now();
        this.updatedAt = this.createdAt; 
    } 
	@PreUpdate
	public void onUpdate() { // 수정 시
        this.updatedAt = this.createdAt; 
    } 
}
