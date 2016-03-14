package com.currency.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.http.ResponseEntity;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureAdapter;

import com.currency.jpa.CurrencyDao;
import com.currency.pojo.Currency;
import com.currency.pojo.CurrencyDTO;
import com.currency.pojo.CurrencyRate;

public class CurrencyRateAdapter extends ListenableFutureAdapter<List<CurrencyDTO>, ResponseEntity<CurrencyRate>>{
	
	private CurrencyDao currencyDao;
	
	public CurrencyRateAdapter(
			ListenableFuture<ResponseEntity<CurrencyRate>> adaptee,
			CurrencyDao dao) {
		super(adaptee);
		this.currencyDao = dao;
	}

	@Override
	protected List<CurrencyDTO> adapt(ResponseEntity<CurrencyRate> adapteeResult)
			throws ExecutionException {
		List<CurrencyDTO> result = new ArrayList<CurrencyDTO>();
		List<Currency> currencies = currencyDao.findAll();
		CurrencyRate rate = adapteeResult.getBody();
		rate.getRates().forEach((code, currencyRate) -> { 
										    CurrencyDTO dto = new CurrencyDTO();
										    dto.setCode(code);
										    dto.setRate(currencyRate);
										    int index = currencies.indexOf(new Currency(code));
										    dto.setName(currencies.get(index).getName());
											result.add(dto);
								});
		return result;
	}
}
