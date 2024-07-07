package com.greetconfigclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetController {

	@Value("${msg}")   //used to get the value of msg property from yml file
	private String mesg;
	
	@GetMapping("/greet")
	public String greetMsg() {
		return mesg;
	}
}
