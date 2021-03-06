package com.currency.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.currency.pojo.CurrencyDTO;
import com.currency.service.CurrencyService;

@RestController
public class CurrencyApi {
	
	@Autowired CurrencyService currencyService;
	
	@RequestMapping("/latest")
	public ListenableFuture<List<CurrencyDTO>> getLatestCurrencyData(){
		return currencyService.getLatest();	
	}
	
	@RequestMapping("/convert")
	public ListenableFuture<Double> convert(@RequestParam String fromCode, 
											@RequestParam String toCode,
											@RequestParam Double fromAmount){
		return currencyService.getConversion(fromCode, toCode, fromAmount);	
	}
	
	@RequestMapping("/validate")
	public ResponseEntity<String> validate(@RequestParam String currency){
		boolean exists = currencyService.exists(currency.toUpperCase().trim());
		ResponseEntity<String> res = null;
		if(!exists)
			res = new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		else
			res = new ResponseEntity<String>(HttpStatus.OK);
		return res;
	}
	
}
