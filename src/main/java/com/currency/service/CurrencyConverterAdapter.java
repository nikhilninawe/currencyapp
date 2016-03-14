package com.currency.service;

import java.util.concurrent.ExecutionException;
import org.springframework.http.ResponseEntity;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureAdapter;
import com.currency.pojo.CurrencyRate;

public class CurrencyConverterAdapter extends ListenableFutureAdapter<Double, ResponseEntity<CurrencyRate>>{
	
	private String fromCode;
	private String toCode;
	private Double amount;

	public CurrencyConverterAdapter(
			ListenableFuture<ResponseEntity<CurrencyRate>> adaptee,
			String fromCode,
			String toCode,
			Double amount) {
		super(adaptee);
		this.fromCode = fromCode;
		this.toCode = toCode;
		this.amount = amount;
	}

	@Override
	protected Double adapt(ResponseEntity<CurrencyRate> adapteeResult)
			throws ExecutionException {
		CurrencyRate rates = adapteeResult.getBody();		
		Double fromRate = rates.getRates().get(fromCode);
		Double toRate = rates.getRates().get(toCode);
		return (amount * toRate) / fromRate;
	}
}
