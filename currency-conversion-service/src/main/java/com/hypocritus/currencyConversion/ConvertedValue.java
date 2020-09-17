package com.hypocritus.currencyConversion;

import java.math.BigDecimal;

public class ConvertedValue {

	long id;
	String from;
	String to;
	BigDecimal conversionRate;
	BigDecimal originalAmount;
	BigDecimal convertedAmount;
	Integer port;

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
	public BigDecimal getOriginalAmount() {
		return originalAmount;
	}
	public void setOriginalAmount(BigDecimal originalAmount) {
		this.originalAmount = originalAmount;
	}
	public BigDecimal getConversionRate() {
		return conversionRate;
	}
	public void setConversionRate(BigDecimal conversionRate) {
		this.conversionRate = conversionRate;
	}
	public BigDecimal getConvertedAmount() {
		return convertedAmount;
	}
	public void setConvertedAmount(BigDecimal convertedAmount) {
		this.convertedAmount = convertedAmount;
	}
	public Integer getPort() {
		return port;
	}
	public void setPort(Integer port) {
		this.port = port;
	}
	
	public ConvertedValue(long id, String from, String to, BigDecimal originalAmount, BigDecimal conversionRate,
			BigDecimal convertedAmount, Integer port) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.originalAmount = originalAmount;
		this.conversionRate = conversionRate;
		this.convertedAmount = convertedAmount;
		this.port = port;
	}
	
	public ConvertedValue() {}
}
