package com.microservicosjava.hruser.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.microservicosjava.hruser.entities.User;
import com.microservicosjava.hruser.repositories.UserRepository;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@Autowired
	UserRepository userRepository;

	@GetMapping("/{id}")
	private ResponseEntity<User> findById(@PathVariable Long id) {
		User response = userRepository.findById(id).get();
		return ResponseEntity.ok(response);
	}

	@GetMapping(value = "/search")
	private ResponseEntity<User> workerById(@RequestParam String email) {
		User response = userRepository.findByEmail(email);
		return ResponseEntity.ok(response);

	}

}
