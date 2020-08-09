package com.cubicit.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.cubicit.controller.Login;

@Repository
public class LoginDao{
	
	@Autowired // ByType, @Qualifier ,@ByName
	private JdbcTemplate jdbcTemplate;
	
	public Login findById(int did){
		String sql = "select id,username,password,doe from user_info_tbl where id = " + did;
		List<Login> loginList = jdbcTemplate.query(sql, new BeanPropertyRowMapper(Login.class));
		/*if(bizList.size()==1){
			return bizList.get(0);
		}
		return null;*/
		return loginList.size()==1 ? loginList.get(0):null;
	}
	
	//true, false
	public boolean isAuth(String username,String password){
		List<Login> loginList=jdbcTemplate.query("select id,username,password,doe from user_info_tbl where username =? and password=?",
				new Object[]{username,password},
				new BeanPropertyRowMapper(Login.class));
		return loginList.size() > 0;
	}
	
	public String updateByUserName(String username,String password){
		int rows=jdbcTemplate.update("update user_info_tbl set password=? where username = ?",password,username);
		String result="Number of row update is  = "+rows;
		return result;
	}
	
	public String deleteByUserName(String username){
		int rows=jdbcTemplate.update("delete from user_info_tbl where username = ?",username);
		String result="Number of row deleted is  = "+rows;
		return result;
	}
	
	public void updateById(Login login){
		String sql="update user_info_tbl set username=?,password=? where id=?";
		Object[] data={login.getUsername(),login.getPassword(),login.getId()};
		jdbcTemplate.update(sql,data);
	}
	
	public void save(Login login){
		String sql="insert into user_info_tbl(username,password,doe) values(?,?,?)";
		Object[] data={login.getUsername(),login.getPassword(),login.getDoe()};
		jdbcTemplate.update(sql,data);
	}
	
	public List<Login> findAll(){
		List<Login> loginList = jdbcTemplate.query("select id,username,password,doe from login_db.user_info_tbl", new BeanPropertyRowMapper(Login.class));
		return loginList; 
	}

}