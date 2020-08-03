package com.service;


import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service("biza") //@Repository , @Component ,@Controller
public class BizService {
	
	@Autowired //it is pulling bean of type DataSource and setting here
	@Qualifier("pmagic") //this is optional do not have to really use it 99.9% of the time 
	//except if there is duplicate data sources.
	private DataSource dataSource;
	
	
	public String updateByName(String name,String brand){
		
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		int rows=jdbcTemplate.update("update biz_service_tbl set brand=? where name = ?",brand,name);
		String result="Number of row update is  = "+rows;
		
		return result;
	}
	
	
	public String deleteByName(String name){

		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		int rows=jdbcTemplate.update("delete from biz_service_tbl where name = ?",name);
		String result="Number of row deleted is  = "+rows;
		
		return result;
	}
	
	public void save(Biz biz){
		String sql="insert into biz_service_tbl(name,brand,doe) values(?,?,?)";
		//??
		Object[] data={biz.getName(),biz.getBrand(),biz.getDoe()};
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		jdbcTemplate.update(sql,data);
		
		System.out.println("saving biz = "+biz);
	}
	
	
	public List<Biz> findAll(){
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		List<Biz> bizList=jdbcTemplate.query("select id,name,brand,doe from biz_service_tbl", new BeanPropertyRowMapper(Biz.class));
		return bizList;
		
	}

}
