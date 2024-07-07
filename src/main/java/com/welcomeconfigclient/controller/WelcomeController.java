package com.welcomeconfigclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
	
	@Value("${msg}")
	private String msg;
	
	@GetMapping("/welcome")
	public String welcomeMsg() {
		return msg;
	}
}
