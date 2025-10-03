package com.wallace.spring.boot.domain.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.wallace.spring.boot.domain.entities.Comment;

public interface CommentRepository extends MongoRepository<Comment, String>{


}
