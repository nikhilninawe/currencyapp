package com.currency;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.currency.CurrencyAppApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = CurrencyAppApplication.class)
@WebAppConfiguration
public class CurrencyAppApplicationTests {

	@Test
	public void contextLoads() {
	}

}
