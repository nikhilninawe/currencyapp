package com.currency.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.client.AsyncRestTemplate;

import com.currency.jpa.CurrencyDao;
import com.currency.pojo.Currency;
import com.currency.pojo.CurrencyDTO;
import com.currency.pojo.CurrencyRate;

@Service
public class CurrencyService {

	private static final String OPEN_EXCHANGE_LATEST_RATES = "https://openexchangerates.org/api/latest.json?app_id=d2fcf80844ab480da4d0b9986c5d147c";

	@Autowired
	private AsyncRestTemplate asyncRestTemplate;
	
	@Autowired CurrencyDao dao;

	public ListenableFuture<List<CurrencyDTO>> getLatest(){
		ListenableFuture<ResponseEntity<CurrencyRate>> rates = 
				asyncRestTemplate.getForEntity(OPEN_EXCHANGE_LATEST_RATES, CurrencyRate.class);
		return new CurrencyRateAdapter(rates, dao);
	}
	
	public ListenableFuture<Double> getConversion(String fromCode, String toCode, Double amount){
		ListenableFuture<ResponseEntity<CurrencyRate>> rates = 
				asyncRestTemplate.getForEntity(OPEN_EXCHANGE_LATEST_RATES, CurrencyRate.class);
		return new CurrencyConverterAdapter(rates, fromCode, toCode, amount);
	}
	
	public boolean exists(String currency){		
		Currency c = dao.findByCode(currency);
		return c != null;
	}
	
}
