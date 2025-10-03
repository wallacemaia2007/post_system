package com.wallace.spring.boot.application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.wallace.spring.boot.domain.dtos.AuthorResponseDTO;
import com.wallace.spring.boot.domain.entities.Post;
import com.wallace.spring.boot.domain.entities.User;
import com.wallace.spring.boot.domain.repository.PostRepository;
import com.wallace.spring.boot.domain.repository.UserRepository;

@Configuration
public class Main implements CommandLineRunner {

	@Autowired
	private UserRepository userReposiroty;
	@Autowired
	private PostRepository postReposiroty;

	@Override
	public void run(String... args) throws Exception {

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		userReposiroty.deleteAll();
		postReposiroty.deleteAll();

		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");

		userReposiroty.saveAll(Arrays.asList(maria, alex, bob));

		Post post1 = new Post(null, "Partiu viagem",
				LocalDate.parse("21/03/2018", formatter),
				"Vou viajar para São Paulo. Abraços!", new AuthorResponseDTO(maria));

		Post post2 = new Post(null, "Bom dia",
				LocalDate.parse("23/03/2018", formatter), "Acordei feliz hoje!", new AuthorResponseDTO(maria));

		postReposiroty.saveAll(Arrays.asList(post1, post2));
		
		maria.getPost().addAll(Arrays.asList(post1, post2));
		userReposiroty.save(maria);
	}
}
