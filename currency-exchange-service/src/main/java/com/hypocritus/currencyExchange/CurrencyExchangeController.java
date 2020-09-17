package com.hypocritus.currencyExchange;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {
	
	@Autowired 
	private Environment env;
	
	@Autowired
	CurrencyExchangeRepository currencyRepo;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@GetMapping(path = "/currencyExchange/{from}/to/{to}")
	public ExchangeValue fetchExchangeValue (@PathVariable String from, @PathVariable String to) {
		/*ExchangeValue exchangeValue = new ExchangeValue(1, "USD", "INR", new BigDecimal(73.84), 
				env.getProperty("local.server.port"));*/
		
		ExchangeValue exchangeValue = currencyRepo.findByFromAndTo(from, to);
		exchangeValue.setPort(env.getProperty("local.server.port"));
		
		logger.info("{}",exchangeValue);
		
		return exchangeValue;
	}
}
