package com.bssys.training.chapter4;

import org.apache.camel.ExchangeProperty;

public class LocalService {

	public String add(@ExchangeProperty("a") String a, @ExchangeProperty("b") String b) {
		Integer intA = Integer.valueOf(a);
		Integer intB = Integer.valueOf(b);
		return String.valueOf(intA + intB);
	}
}
