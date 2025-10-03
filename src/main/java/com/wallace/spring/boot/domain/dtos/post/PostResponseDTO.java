package com.wallace.spring.boot.domain.dtos.post;

import java.time.LocalDate;
import java.util.List;

import com.wallace.spring.boot.domain.dtos.post.comment.CommentResponseDTO;
import com.wallace.spring.boot.domain.entities.Post;

public record PostResponseDTO(String id, String title, LocalDate date, String description, AuthorResponseDTO author,
		List<CommentResponseDTO> comments) {
	
	public PostResponseDTO(Post post) {
		this(post.getId(), post.getTitle(), post.getDate(), post.getDescription(), post.getAuthor(),
				post.getComments().stream()
						.map(c -> new CommentResponseDTO(c.getText(), c.getDate(), c.getAuthorResponseDTO())).toList());
	}
}
