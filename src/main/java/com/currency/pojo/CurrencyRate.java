package com.currency.pojo;

import java.util.Map;

public class CurrencyRate {
	
	private Map<String, Double> rates;
	private String base;
	private Long timestamp;
	public Map<String, Double> getRates() {
		return rates;
	}
	public void setRates(Map<String, Double> rates) {
		this.rates = rates;
	}
	public String getBase() {
		return base;
	}
	public void setBase(String base) {
		this.base = base;
	}
	public Long getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}
	@Override
	public String toString() {
		return "CurrencyRate [rates=" + rates + ", base=" + base
				+ ", timestamp=" + timestamp + "]";
	}
}
