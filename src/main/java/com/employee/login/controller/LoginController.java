package com.employee.login.controller;

import java.util.Date;

import javax.servlet.ServletException;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.employee.login.model.Employee;
import com.employee.login.response.TokenResponse;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;


@RestController
@RequestMapping("/api/login")
public class LoginController {
	
	
	@RequestMapping(method = RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TokenResponse> login(@RequestBody Employee emp) throws ServletException {

		String jwtToken = "";

		if (emp.getUserName() == null || emp.getPassword() == null) {
			throw new ServletException("Please fill in username and password");
		}

		String username = emp.getUserName();
		String password = emp.getPassword();


		

		if (!password.equals("admin") || !username.equals("admin")) {
			throw new ServletException("Invalid login. Please check your name and password.");
		}

		jwtToken = Jwts.builder().setSubject(username).claim("roles", "user").setIssuedAt(new Date())
				.signWith(SignatureAlgorithm.HS256, "secretkey").compact();
		TokenResponse res = new TokenResponse();
		res.setToken(jwtToken);

		return new ResponseEntity<TokenResponse>(res, HttpStatus.OK);
	}

}
