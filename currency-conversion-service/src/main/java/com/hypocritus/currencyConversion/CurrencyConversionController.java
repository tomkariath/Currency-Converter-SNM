package com.hypocritus.currencyConversion;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyConversionController {
	
	@Autowired
	CurrencyExchangeProxy proxy;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@GetMapping(path = "/currencyConvert/{from}/to/{to}/amount/{amount}")
	public ConvertedValue calculateConvertedValue(@PathVariable String from, 
			@PathVariable String to, @PathVariable BigDecimal amount){
		
		/*
		 * Map<String, String> pathVariables = new HashMap<String, String>();
		 * pathVariables.put("from", from); pathVariables.put("to", to);
		 * 
		 * ConvertedValue response = new RestTemplate()
		 * .getForEntity("http://localhost:8001/currencyExchange/{from}/to/{to}",
		 * ConvertedValue.class, pathVariables).getBody();
		 */
		
		
		ConvertedValue response = proxy.fetchExchangeValue(from, to);

		logger.info("{}",response);
		
		return new ConvertedValue(response.getId(), response.getFrom(), response.getTo(), amount, 
				response.getConversionRate(), amount.multiply(response.getConversionRate()),response.getPort());		
	}
}
