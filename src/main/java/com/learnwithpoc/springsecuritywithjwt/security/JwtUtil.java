package com.learnwithpoc.springsecuritywithjwt.security;

import java.security.Key;
import java.util.Base64;
import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.learnwithpoc.springsecuritywithjwt.exception.InvalidJwtTokenException;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil {

	@Value("${jwt.secretkey}")
	private String secret;

	@Value("${jwt.expiration}")
	private Long expiration;

	public void validateToken(String jwtToken) throws InvalidJwtTokenException {
		
		Key key  = Keys.hmacShaKeyFor(secret.getBytes());
		
		try {
			Claims claims = Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(jwtToken).getBody();
			
			Date expirationDate = claims.getExpiration();
			Date currentDate = new Date();
			if(currentDate.after(expirationDate)) {
				throw new InvalidJwtTokenException("Token has expired");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			throw new InvalidJwtTokenException("Token validation failed");
		}

	}

	public String generateToken(Map<String, Object> claims) {
		System.out.println(secret + " ========= " + expiration);
		return Jwts.builder().setClaims(claims).setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + expiration))
				.signWith(SignatureAlgorithm.HS512, Base64.getEncoder().encodeToString(secret.getBytes())).compact();
	}

}
