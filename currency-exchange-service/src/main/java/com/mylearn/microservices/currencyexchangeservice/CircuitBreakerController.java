package com.mylearn.microservices.currencyexchangeservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;

@RestController
public class CircuitBreakerController {

	
	private Logger log = LoggerFactory.getLogger(CircuitBreakerController.class);
	
	@GetMapping("/sample")
//	@Retry(name = "sample", fallbackMethod = "fallbackRes")
	//@CircuitBreaker(name = "sample", fallbackMethod = "fallbackRes")
	@RateLimiter(name="sample")
	public String sampleApi() {
		log.info("In Sample");
//		ResponseEntity<String> entity = new RestTemplate().getForEntity("http://localhost:1000/mis", String.class); 
//		return entity.getBody();
		return "Sample";
	}
	
	public String fallbackRes(Exception e) {
		return e.getMessage();
	}
}
