package com.hypocritus.currencyConversion;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "api-gateway")
@RibbonClient(name = "currency-exchange-service")
public interface CurrencyExchangeProxy {

	@GetMapping(path = "/currency-exchange-service/currencyExchange/{from}/to/{to}")
	public ConvertedValue fetchExchangeValue (@PathVariable String from, @PathVariable String to);
}
