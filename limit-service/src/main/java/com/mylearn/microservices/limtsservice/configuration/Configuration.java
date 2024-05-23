package com.mylearn.microservices.limtsservice.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@org.springframework.context.annotation.Configuration
@ConfigurationProperties("limits-service")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Configuration {

	private int min;
	private int max;
}
