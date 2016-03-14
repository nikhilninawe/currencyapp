package com.currency.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.currency.pojo.Currency;

public interface CurrencyDao extends JpaRepository<Currency, Long>, JpaSpecificationExecutor<Currency>  {
	
	List<Currency> findAll();

}
