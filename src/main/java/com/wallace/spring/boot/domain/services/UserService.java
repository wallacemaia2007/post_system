package com.wallace.spring.boot.domain.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wallace.spring.boot.domain.dtos.UserRequestDTO;
import com.wallace.spring.boot.domain.entities.User;
import com.wallace.spring.boot.domain.repository.UserRepository;
import com.wallace.spring.boot.exceptions.UserNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public List<User> findAll() {
		return userRepository.findAll();
	}

	public User findById(String id) {
		return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("Usuário não encontrado!"));
	}

	public User createUser(UserRequestDTO userRequestDTO) {
		User user = new User(null, userRequestDTO.name(), userRequestDTO.email());
		userRepository.save(user);

		return user;
	}

	public void deleteById(String id) {
		findById(id);
		userRepository.deleteById(id);
	}

	public User uptadeUser(String id, UserRequestDTO userRequestDTO) {
		User user = findById(id);
		user.setName(userRequestDTO.name());
		user.setEmail(userRequestDTO.email());
		userRepository.save(user);

		return user;
	}

}
