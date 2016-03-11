package com.bssys.training.chapter5;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class LocalService {
	
	private static Logger log = Logger.getLogger(LocalService.class);
	
	private JdbcTemplate template;
	
	public LocalService(JdbcTemplate template) {
		this.template = template;
	}

	public List<Map<String, Object>> get(){
		long startTime = System.currentTimeMillis();
		List<Map<String, Object>> queryMap = template.query("select * from TEST",				
				new RowMapper<Map<String, Object>>() {
					public Map<String, Object> mapRow(ResultSet rs, int arg1)
							throws SQLException {

						HashMap<String, Object> resMap = new HashMap<String, Object>();
						int columnCount = rs.getMetaData().getColumnCount();

						for (int i = 1; i <= columnCount; i++) {
							String columnName = rs.getMetaData()
									.getColumnName(i).toLowerCase();
							Object value = rs.getString(i);
							resMap.put(columnName, value);
						}
						return resMap;
					}
				});
		
		
		log.info("get time:"+(System.currentTimeMillis()-startTime));
		return queryMap;
	}


}
