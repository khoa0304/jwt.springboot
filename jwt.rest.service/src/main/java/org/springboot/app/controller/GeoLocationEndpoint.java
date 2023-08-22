package org.springboot.app.controller;

import javax.annotation.PostConstruct;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GeoLocationEndpoint {

	@PostConstruct
	public void init() {
		System.out.println("Init");
	}

	

	@PostMapping(path = "/thread/providers/{eventType}", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Object> eloquaRestEndpoint(@RequestBody String payload) {

		return ResponseEntity.ok(payload);

	}
}
