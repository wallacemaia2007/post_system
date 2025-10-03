package com.wallace.spring.boot.domain.entities;

import java.io.Serializable;
import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.wallace.spring.boot.domain.dtos.post.AuthorResponseDTO;

@Document(collection = "comment")
public class Comment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	private String text;
	private LocalDate date;
	private AuthorResponseDTO authorResponseDTO;

	public Comment() {
	}

	public Comment(String id, String text, LocalDate date, AuthorResponseDTO authorResponseDTO) {
		this.id = id;
		this.text = text;
		this.date = date;
		this.authorResponseDTO = authorResponseDTO;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public AuthorResponseDTO getAuthorResponseDTO() {
		return authorResponseDTO;
	}

	public void setAuthorResponseDTO(AuthorResponseDTO authorResponseDTO) {
		this.authorResponseDTO = authorResponseDTO;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	

}
