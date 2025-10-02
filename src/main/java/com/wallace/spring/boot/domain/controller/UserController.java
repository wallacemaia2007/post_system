package com.wallace.spring.boot.domain.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wallace.spring.boot.domain.dtos.UserResponseDTO;
import com.wallace.spring.boot.domain.entities.User;
import com.wallace.spring.boot.domain.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping
	public ResponseEntity<List<UserResponseDTO>> findAll() {

		List<User> list = userService.findAll();
		List<UserResponseDTO> listResponse = list.stream().map(UserResponseDTO::new).toList();

		return ResponseEntity.ok().body(listResponse);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UserResponseDTO> findById(@PathVariable String id) {

		User user = userService.findById(id);
		UserResponseDTO userResponse = new UserResponseDTO(user);

		return ResponseEntity.ok().body(userResponse);
	}
}
