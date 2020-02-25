package com.jdv.security.resource;

import com.jdv.security.domain.ApplicationUser;
import com.jdv.security.service.UserService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/registration")
public class RegistrationResource {
	private UserService userService;

	@Autowired
	public RegistrationResource (UserService userService) {
		this.userService = userService;
	}

	@PostMapping
	public String registerUser(@RequestBody ApplicationUser user) {
		return userService.saveUser(user);
	}
}
