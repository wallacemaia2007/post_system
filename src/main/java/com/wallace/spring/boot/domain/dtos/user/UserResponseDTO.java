package com.wallace.spring.boot.domain.dtos.user;

import com.wallace.spring.boot.domain.entities.User;

public record UserResponseDTO(String id, String name, String email) {

	public UserResponseDTO(User user) {
		this(user.getId(), user.getName(), user.getEmail());
	}

}
