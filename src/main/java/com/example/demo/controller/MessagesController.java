package com.example.demo.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/messages")
public class MessagesController {

	@GetMapping
	public ResponseEntity<List<String>> messages() {
		return ResponseEntity.ok(Arrays.asList("first","second"));
	}
	
}
