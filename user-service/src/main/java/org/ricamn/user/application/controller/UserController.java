package org.ricamn.user.application.controller;

import java.security.Principal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.ricamn.user.application.UserNotFoundException;
import org.ricamn.user.application.UserService;
import org.ricamn.user.domain.User;

@RestController
@RequestMapping(value = "/users")
public class UserController {

	private UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(value = "/me")
	public ResponseEntity<User> getCurrentUser(Principal principal) {
		User user = null;

		if (principal != null) {
			user = userService.getByUserName(principal.getName());
		}

		return Optional.ofNullable(user).map(u -> new ResponseEntity<User>(u, HttpStatus.OK))
				.orElseThrow(() -> new UserNotFoundException("User not found"));
	}
}
