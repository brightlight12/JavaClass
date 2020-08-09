package com.cubicit.dao;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import com.mysql.cj.jdbc.MysqlDataSource;

@Configuration
public class DBConfig {
	
	
	@Bean("jdbcTemplate") //
	public JdbcTemplate createTemplate(){
		JdbcTemplate jdbcTemplate=new JdbcTemplate(this.dataSource());
		return jdbcTemplate;
	}
	
	
	@Bean("nameAnything") //you can provide any name here
	public DataSource dataSource() {
		MysqlDataSource mysqlDS = new MysqlDataSource();
		mysqlDS.setURL("jdbc:mysql://localhost:3306/login_db?serverTimezone=UTC");
		mysqlDS.setUser("root");
		mysqlDS.setPassword("singha123");
		return mysqlDS;
	}

}