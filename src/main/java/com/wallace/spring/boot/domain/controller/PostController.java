package com.wallace.spring.boot.domain.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wallace.spring.boot.domain.dtos.PostResponseDTO;
import com.wallace.spring.boot.domain.entities.Post;
import com.wallace.spring.boot.domain.services.PostService;
import com.wallace.spring.boot.domain.util.URL;

@RestController
@RequestMapping(value = "/posts")
public class PostController {
	
	@Autowired
	private PostService postService;
	
	@GetMapping("/{id}")
	public ResponseEntity<PostResponseDTO> findById(@PathVariable String id) {

		Post post = postService.findById(id);
		PostResponseDTO postResponseDTO = new PostResponseDTO(post);

		return ResponseEntity.ok().body(postResponseDTO);
	}
	
	@GetMapping("/titlesearch")
	public ResponseEntity<List<PostResponseDTO>> findByTitle(@RequestParam(value = "text", defaultValue = "") String text) {

		text = URL.deccodeParam(text);
		List<Post> list = postService.finByTitle(text);
		List<PostResponseDTO> listResponse = list.stream().map(PostResponseDTO::new).toList();

		return ResponseEntity.ok().body(listResponse);
	}
	
	
	

}
