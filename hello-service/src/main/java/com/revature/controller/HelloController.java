package com.revature.controller;

import java.util.HashMap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class HelloController {
	
	@GetMapping("")
	public HashMap<String, String> sayHello() {
		HashMap<String, String> map = new HashMap<>();
		map.put("message", "hello Cindy");
		return map;
	}
}
