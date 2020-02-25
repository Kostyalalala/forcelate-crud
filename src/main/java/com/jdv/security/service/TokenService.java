package com.jdv.security.service;

public interface TokenService {
	String createToken(String userId);
	String getUserIdFromToken(String token);
	boolean isTokenValid(String token);
}
