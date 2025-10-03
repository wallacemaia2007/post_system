package com.wallace.spring.boot.domain.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wallace.spring.boot.domain.dtos.post.PostRequestDTO;
import com.wallace.spring.boot.domain.entities.Post;
import com.wallace.spring.boot.domain.repository.PostRepository;
import com.wallace.spring.boot.exceptions.PostNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository postRepository;

	public Post findById(String id) {
		return postRepository.findById(id).orElseThrow(() -> new PostNotFoundException("Invalid id for post"));
	}

	public List<Post> finByTitle(String text) {
		return postRepository.findByTitleContainingIgnoreCase(text);
	}

	public void deleteById(String id) {
		postRepository.deleteById(id);

	}

	public Post createPost(PostRequestDTO postRequestDTO) {
		Post post = new Post(postRequestDTO.id(), postRequestDTO.title(), postRequestDTO.date(),
				postRequestDTO.description(), postRequestDTO.author());
		postRepository.save(post);
		return post;

	}

	public Post createPost(String id, PostRequestDTO postRequestDTO) {
		Post post = findById(id);
		post.setDate(postRequestDTO.date());
		post.setAuthor(postRequestDTO.author());
		post.setDescription(postRequestDTO.description());
		post.setTitle(postRequestDTO.title());
		postRepository.save(post);
		return post;
	}

	public List<Post> findAll() {
		return postRepository.findAll();
	}

}
