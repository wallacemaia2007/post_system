package com.wallace.spring.boot.domain.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wallace.spring.boot.domain.dtos.post.PostResponseDTO;
import com.wallace.spring.boot.domain.dtos.user.UserRequestDTO;
import com.wallace.spring.boot.domain.dtos.user.UserResponseDTO;
import com.wallace.spring.boot.domain.entities.Post;
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

	@PostMapping
	public ResponseEntity<UserResponseDTO> createUser(@RequestBody UserRequestDTO UserRequestDTO) {

		User user = userService.createUser(UserRequestDTO);
		UserResponseDTO userResponseDTO = new UserResponseDTO(user);

		return ResponseEntity.status(HttpStatus.CREATED).body(userResponseDTO);

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable String id) {

		userService.deleteById(id);

		return ResponseEntity.noContent().build();

	}

	@PutMapping("/{id}")
	public ResponseEntity<UserResponseDTO> uptadeUser(@PathVariable String id,
			@RequestBody UserRequestDTO userRequestDTO) {
		User user = userService.uptadeUser(id, userRequestDTO);
		UserResponseDTO userResponseDTO = new UserResponseDTO(user);

		return ResponseEntity.ok(userResponseDTO);

	}

	@GetMapping("/{id}/posts")
	public ResponseEntity<List<PostResponseDTO>> findPostsById(@PathVariable String id) {
		User user = userService.findById(id);
		List<Post> list = user.getPosts();
		List<PostResponseDTO> listResponse = list.stream().map(PostResponseDTO::new).toList();

		return ResponseEntity.ok().body(listResponse);

	}
}
