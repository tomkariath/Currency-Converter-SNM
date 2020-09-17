package com.hypocritus.microservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitsServiceConfigurationController {
	
	@Autowired
	private Configuration config;
	
	@GetMapping(path = "/limits")
	LimitsConfiguration getLimitsConfiguration() {
		return new LimitsConfiguration(config.getMinimum(), config.getMaximum());
	}
}
