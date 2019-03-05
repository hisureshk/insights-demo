package com.pru.insights.insightsdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InternalHelloController {

	@GetMapping("/hello")
	public String hello() {
		return "Hello ..";
	}

}