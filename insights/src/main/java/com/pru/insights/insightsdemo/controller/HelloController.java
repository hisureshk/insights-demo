package com.pru.insights.insightsdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import com.microsoft.applicationinsights.TelemetryClient;
import org.springframework.http.client.ClientHttpRequestFactory;

@RestController
public class HelloController {

	@Autowired
	TelemetryClient telemetryClient;

	@Autowired
	RestTemplate restTemplate;

	@GetMapping("/hello")
	@CrossOrigin(origins = "http://localhost:3000")

	public String hello() {
		// track a custom dependency
		ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:8085/hello", String.class);
		return response.toString();// "Hello ..";
	}

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate(httpRequestFactory());
	}

	@Bean
	public ClientHttpRequestFactory httpRequestFactory() {
		return new HttpComponentsClientHttpRequestFactory();
	}

}