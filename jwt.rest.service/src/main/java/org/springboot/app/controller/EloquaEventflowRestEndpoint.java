package org.springboot.app.controller;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.atomic.AtomicInteger;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EloquaEventflowRestEndpoint {
	@Autowired
	public InMemoryUserDetailsManager inMemoryUserDetailsManager;

	@Autowired
	public PasswordEncoder passwordEncoder;
	
	@PostConstruct
	public void init() {
		System.out.println("Init");
	}

	private AtomicInteger counter = new AtomicInteger(1);
	LocalDateTime ldt1 = LocalDateTime.now();
	
	@PostMapping(path= "/account/{accountToken}/{eventType}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> addEmployee(@RequestBody String payload,
    		@PathVariable(value="accountToken") final String accountToken,
    		@PathVariable(value="eventType") final String eventType) 
    {
		LocalDateTime ldt2 = LocalDateTime.now();
		long elapseInMs = Math.abs(ChronoUnit.MILLIS.between(ldt1,ldt2));
		System.out.println("Elapse in "+ elapseInMs+" ms - Time: "+ LocalDateTime.now()+ "- Counter "+ counter.getAndIncrement()+" Receiving " + accountToken +" - " + eventType);
        System.out.println(payload);
        System.out.println();
        ldt1 =ldt2;
        
        return ResponseEntity.ok(payload);
      
    }
}
