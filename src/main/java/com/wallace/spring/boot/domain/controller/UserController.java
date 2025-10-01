package com.wallace.spring.boot.domain.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wallace.spring.boot.domain.entities.User;

@RestController
@RequestMapping(value = "/users")
public class UserController {

	@GetMapping
	public ResponseEntity<List<User>> findAll() {
		User u1 = new User(1, "Lucas", "lucas123");
		User u2 = new User(2, "maria", "maria123");

		List<User> list = new ArrayList<>();

		list.addAll(Arrays.asList(u1, u2));

		return ResponseEntity.ok().body(list);
	}
}
