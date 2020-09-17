package com.hypocritus.currencyExchange;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ExchangeValue {

	@Id
	long id;
	
	@Column(name = "currency_from")
	String from;
	@Column(name = "currency_to")
	String to;
	BigDecimal conversionRate;
	String port;
	
	public String getPort() {
		return port;
	}
	public void setPort(String port) {
		this.port = port;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public BigDecimal getConversionRate() {
		return conversionRate;
	}
	public void setConversionRate(BigDecimal conversionRate) {
		this.conversionRate = conversionRate;
	}
	
	public ExchangeValue(long id, String from, String to, BigDecimal conversionRate, String port) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.conversionRate = conversionRate;
		this.port = port;
	}
	
	public ExchangeValue(long id, String from, String to, BigDecimal conversionRate) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.conversionRate = conversionRate;
	}
	
	public ExchangeValue() {}
}
