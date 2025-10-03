package com.wallace.spring.boot.domain.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	
	public List<Post> finByTitle(String text){
		return postRepository.findByTitleContainingIgnoreCase(text);
	}

}
