package org.learn.app.controllers;

import java.util.List;

import org.learn.app.daoImpl.UserDAOImpl;
import org.learn.app.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class RegisterController {

	@Autowired
	private UserDAOImpl userDAOImpl;

	/*
	 * get all data
	 */

	@GetMapping("/getall")
	public List<Users> getData() {
		return userDAOImpl.getAll();
	}
	/*
	 * create data for user
	 */

	@PostMapping("/save")
	public ResponseEntity<Users> createUsers(@RequestBody Users postUser) {
		Users user = null;
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json");
		headers.add("Responded", "RegisterController");
		try {
			userDAOImpl.saveUser(postUser);
		} catch (Exception e) {
			System.out.println("Employee Not Found :-" + e);
			return ResponseEntity.ok().headers(headers).body(user);
		}
		return ResponseEntity.ok().headers(headers).body(user);
	}

}
