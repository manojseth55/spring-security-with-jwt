package com.learnwithpoc.springsecuritywithjwt.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.learnwithpoc.springsecuritywithjwt.exception.InvalidJwtTokenException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtInterceptor implements HandlerInterceptor {

	@Autowired
	private JwtUtil jwtUtil;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String token = request.getHeader("Authorization");
		if (token == null || !token.startsWith("Bearer ")) {
			throw new InvalidJwtTokenException("No token provided");
		}

		token = token.substring(7);
		try {
			jwtUtil.validateToken(token);
		} catch (Exception e) {
			// TODO: handle exception
			throw new InvalidJwtTokenException("Token Validation failed");
		}
		return true;

	}

}
