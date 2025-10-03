package com.wallace.spring.boot.domain.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.wallace.spring.boot.domain.entities.Post;

public interface PostRepository extends MongoRepository<Post, String>{
	
	public List<Post> findByTitleContainingIgnoreCase(String text);


}
