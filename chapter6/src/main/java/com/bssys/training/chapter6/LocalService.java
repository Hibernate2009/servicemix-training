package com.bssys.training.chapter6;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.apache.camel.language.XPath;
import org.springframework.jdbc.core.JdbcTemplate;

public class LocalService {

	private JdbcTemplate template;

	public LocalService(JdbcTemplate template) {
		this.template = template;
	}

	public void credit(@XPath("/transaction/@name") String name,
			@XPath("/transaction/credit/@amount") String amount) {

		int origAmount = -1;
		List<Map<String, Object>> queryForList = template.queryForList("select amount from accounts where name = ?", new String[] { name });
		
		if (queryForList.isEmpty()){
			throw new IllegalStateException("Not found name:"+name);
		}
		for (Map<String, Object> map:queryForList){
			origAmount = Integer.valueOf((String)map.get("amount"));
		}
		
		int newAmount = origAmount + Integer.parseInt(amount);
		template.update("update accounts set amount = ? where name = ?", new Object[] { newAmount, name });
	}

	
	public void debit(@XPath("/transaction/@name") String name,
			@XPath("/transaction/debit/@amount") String amount) {

		int origAmount = template.queryForObject("select amount from accounts where name = ?", new String[] { name }, Integer.class);
		int newAmount = origAmount - Integer.parseInt(amount);
		if (newAmount < 0) {
			throw new IllegalStateException("Not enough in account");
		}

		template.update("update accounts set amount = ? where name = ?", new Object[] { newAmount, name });
	}
}
