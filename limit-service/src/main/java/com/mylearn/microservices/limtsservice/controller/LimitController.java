package com.mylearn.microservices.limtsservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mylearn.microservices.limtsservice.bean.Limits;
import com.mylearn.microservices.limtsservice.configuration.Configuration;

@RestController
public class LimitController {

	@Autowired
	private Configuration configuration;
	
	@GetMapping("/limits")
	public Limits retrieveLimits() {
		return new Limits(configuration.getMin(),configuration.getMax());
//		return new Limits(1,10000);
	}
}
