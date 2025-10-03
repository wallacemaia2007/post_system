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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wallace.spring.boot.domain.dtos.post.PostRequestDTO;
import com.wallace.spring.boot.domain.dtos.post.PostResponseDTO;
import com.wallace.spring.boot.domain.entities.Post;
import com.wallace.spring.boot.domain.services.PostService;
import com.wallace.spring.boot.domain.util.URL;

@RestController
@RequestMapping(value = "/posts")
public class PostController {

	@Autowired
	private PostService postService;

	@GetMapping
	public ResponseEntity<List<PostResponseDTO>> findAll() {

		List<Post> list = postService.findAll();
		List<PostResponseDTO> listResponse = list.stream().map(PostResponseDTO::new).toList();

		return ResponseEntity.ok().body(listResponse);
	}

	@GetMapping("/{id}")
	public ResponseEntity<PostResponseDTO> findById(@PathVariable String id) {

		Post post = postService.findById(id);
		PostResponseDTO postResponseDTO = new PostResponseDTO(post);

		return ResponseEntity.ok().body(postResponseDTO);
	}

	@GetMapping("/titlesearch")
	public ResponseEntity<List<PostResponseDTO>> findByTitle(
			@RequestParam(value = "text", defaultValue = "") String text) {

		text = URL.decodeParam(text);
		List<Post> list = postService.findByTitle(text);
		List<PostResponseDTO> listResponse = list.stream().map(PostResponseDTO::new).toList();

		return ResponseEntity.ok().body(listResponse);
	}

	@PostMapping
	public ResponseEntity<PostResponseDTO> createPost(@RequestBody PostRequestDTO postRequestDTO) {
		Post post = postService.createPost(postRequestDTO);
		PostResponseDTO postResponseDTO = new PostResponseDTO(post);

		return ResponseEntity.status(HttpStatus.CREATED).body(postResponseDTO);

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable String id) {

		postService.deleteById(id);

		return ResponseEntity.noContent().build();

	}

	@PutMapping("/{id}")
	public ResponseEntity<PostResponseDTO> uptadePost(@PathVariable String id,
			@RequestBody PostRequestDTO postRequestDTO) {
		Post post = postService.updatePost(id, postRequestDTO);
		PostResponseDTO postResponseDTO = new PostResponseDTO(post);

		return ResponseEntity.ok(postResponseDTO);

	}

}
