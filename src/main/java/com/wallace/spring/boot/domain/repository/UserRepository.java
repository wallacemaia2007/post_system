package com.wallace.spring.boot.domain.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.wallace.spring.boot.domain.entities.User;

public interface UserRepository extends MongoRepository<User, String>{


}
