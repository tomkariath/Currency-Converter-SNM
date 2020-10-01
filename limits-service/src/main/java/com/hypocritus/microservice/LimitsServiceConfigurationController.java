package com.hypocritus.microservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@EnableHystrix
public class LimitsServiceConfigurationController {
	
	@Autowired
	private Configuration config;
	
	@GetMapping(path = "/limits")
	LimitsConfiguration getLimitsConfiguration() {
		return new LimitsConfiguration(config.getMinimum(), config.getMaximum());
	}
	
	@GetMapping(path = "/faultCheck")
	@HystrixCommand(fallbackMethod = "fallbackConfiguration")
	LimitsConfiguration checkFaultTolerance() {
		throw new RuntimeException("checking fault tolerance");
	}
	
	LimitsConfiguration fallbackConfiguration(){
		return new LimitsConfiguration(1,23);
	}
}
