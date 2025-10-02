package com.wallace.spring.boot.domain.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wallace.spring.boot.domain.entities.User;
import com.wallace.spring.boot.domain.repository.UserRepository;
import com.wallace.spring.boot.exceptions.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public List<User> findAll() {
		return userRepository.findAll();
	}

	public User findById(String id) {
		return userRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Usuário não encontrado!"));
	}

}
