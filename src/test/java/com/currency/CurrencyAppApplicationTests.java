package com.currency;

import java.util.List;
import java.util.concurrent.ExecutionException;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.concurrent.ListenableFuture;

import com.currency.CurrencyAppApplication;
import com.currency.controller.CurrencyApi;
import com.currency.pojo.CurrencyDTO;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = CurrencyAppApplication.class)
@WebAppConfiguration
public class CurrencyAppApplicationTests {
	
	@Autowired CurrencyApi api;

	@Test
	public void contextLoads() throws InterruptedException, ExecutionException {
		
		ListenableFuture<List<CurrencyDTO>> ls = api.getLatestCurrencyData();
		assertEquals(171, ls.get().size());
		
		ListenableFuture<Double> converted = api.convert("AED", "INR", 1.0);
		assertEquals(18.23, converted.get().doubleValue(), 0.1);
	}

}
