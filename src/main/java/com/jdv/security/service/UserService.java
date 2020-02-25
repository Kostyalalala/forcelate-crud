package com.jdv.security.service;

import com.jdv.security.domain.ApplicationUser;

public interface UserService {
	ApplicationUser getUser(String userId);
	String saveUser(ApplicationUser user);
}