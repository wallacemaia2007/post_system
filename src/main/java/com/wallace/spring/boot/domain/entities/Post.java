package com.wallace.spring.boot.domain.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.wallace.spring.boot.domain.dtos.post.AuthorResponseDTO;

@Document(collection = "post")
public class Post implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	private String title;
	private LocalDate date;
	private String description;
	private AuthorResponseDTO author;
	
	private List<Comment> comments = new ArrayList<>();

	public Post(String id, String title, LocalDate date, String description, AuthorResponseDTO author) {
		this.author = author;
		this.id = id;
		this.title = title;
		this.date = date;
		this.description = description;
	}

	public Post() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public AuthorResponseDTO getAuthor() {
		return author;
	}

	public void setAuthor(AuthorResponseDTO author) {
		this.author = author;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Post other = (Post) obj;
		return Objects.equals(id, other.id);
	}

}
