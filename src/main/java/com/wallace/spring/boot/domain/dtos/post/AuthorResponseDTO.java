package com.wallace.spring.boot.domain.dtos.post;

import com.wallace.spring.boot.domain.entities.User;

public record AuthorResponseDTO(String id , String name) {

	public AuthorResponseDTO(User user) {
		this(user.getId(), user.getName());
	}

}
