package com.wallace.spring.boot.domain.dtos;

import java.time.LocalDate;

import com.wallace.spring.boot.domain.entities.Post;

public record PostResponseDTO(String id, String title, LocalDate date, String description, AuthorResponseDTO author) {
	
	public PostResponseDTO(Post post) {
		this(post.getId(), post.getTitle(), post.getDate(), post.getDescription(), post.getAuthor());
	}

}
