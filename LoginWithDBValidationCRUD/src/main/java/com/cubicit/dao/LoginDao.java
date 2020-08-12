package com.cubicit.dao;

import java.io.IOException;
import java.sql.Types;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.SqlLobValue;
import org.springframework.jdbc.support.lob.DefaultLobHandler;
import org.springframework.jdbc.support.lob.LobHandler;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

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
		List<Login> loginList=jdbcTemplate.query("select id,username,password,doe from user_info_tbl where username LIKE BINARY ? and password LIKE BINARY ?",
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
	
	public String deletecPhoto(int id){
		int rows = jdbcTemplate.update("delete from user_photos_tbl where photoid = ?",id);
		String result="Number of row deleted is  = " + rows;
		return result;
	}
	
	public String deleteById(int id){
		int rows=jdbcTemplate.update("delete from user_info_tbl where id = ?",id);
		String result="Number of row deleted is  = "+rows;
		return result;
	}
	
	public void updateById(Login login){
		String sql="update user_info_tbl set username=?,password=? where id=?";
		Object[] data={login.getUsername(),login.getPassword(),login.getId()};
		jdbcTemplate.update(sql,data);
	}
	
	public byte[] findPhotoById(int dbid){
		byte[] photo=jdbcTemplate.queryForObject("select photo from user_info_tbl where id = " + dbid, byte[].class);
		return photo;
	}
	
	public byte[] cfindPhotoById(int dbid){
		byte[] photo=jdbcTemplate.queryForObject("select photo from user_photos_tbl where photoid = " + dbid, byte[].class);
		return photo;
	}
	
	public void save(Login login){
		try {
			MultipartFile[] multipartFiles = login.getFile();
			int pid=0;
			if(multipartFiles.length>0){
				byte[] photo = multipartFiles[0].getBytes();
				LobHandler lobHandler = new DefaultLobHandler();
				SqlLobValue sqlLobValue = new SqlLobValue(photo,lobHandler);
				String sql = "insert into user_info_tbl(username, password, doe, photo) values(?,?,?,?)";
				Object[] data={login.getUsername(), login.getPassword(), login.getDoe(), sqlLobValue};
				//This is just syntax !!!!!!!!!!!!!!!!!!!
				int dataType[] ={Types.VARCHAR,Types.VARCHAR,Types.TIMESTAMP,Types.BLOB};
				jdbcTemplate.update(sql, data, dataType);	
				String maxid = "select max(id) from user_info_tbl";
				pid = jdbcTemplate.queryForObject(maxid, Integer.class);
			}
			int i = 0;
			for(MultipartFile multipartFile:multipartFiles){
				if(i > 0){
					byte[] photo = multipartFile.getBytes();
					LobHandler lobHandler = new DefaultLobHandler();
					SqlLobValue sqlLobValue = new SqlLobValue(photo,lobHandler);
					String imagesql="insert into user_photos_tbl(photo, pid) values(?,?)";
					Object[] data = {sqlLobValue, pid};
					//This is just syntax !!!!!!!!!!!!!!!!!!!
					int dataType[] = {Types.BLOB,Types.INTEGER};
					jdbcTemplate.update(imagesql, data, dataType);	
				}
				 i++;	
		}
		}   catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public List<Login> findAll(){
		List<Login> loginList = jdbcTemplate.query("select id, username, password, doe from user_info_tbl", new BeanPropertyRowMapper(Login.class));
		for(Login login : loginList){
			String sql = "select photoid from user_photos_tbl where pid = " + login.getId();
			List<Integer> cimageIds = jdbcTemplate.queryForList(sql,Integer.class);
			login.setCimageid(cimageIds);
		}
		return loginList;
	}

}