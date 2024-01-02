package com.learnwithpoc.springsecuritywithjwt.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learnwithpoc.springsecuritywithjwt.security.JwtUtil;

@RestController
@RequestMapping("/oauth")
public class JwtTokenGeneratorController {

	@Autowired
	private JwtUtil jwtUtil;

	@GetMapping("/accesstoken")
	public String getToken() {
		HashMap<String, Object> claims = new HashMap<String, Object>();
		return jwtUtil.generateToken(claims);
	}
}
