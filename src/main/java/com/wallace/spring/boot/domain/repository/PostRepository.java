package com.wallace.spring.boot.domain.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.wallace.spring.boot.domain.entities.Post;

public interface PostRepository extends MongoRepository<Post, String>{


}
