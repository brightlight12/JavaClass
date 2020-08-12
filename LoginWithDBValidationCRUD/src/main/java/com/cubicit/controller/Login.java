package com.cubicit.controller;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class Login {
	
	private int id;
	private String username;
	private String password;
	private Timestamp doe;
	//This is used to store file
	private MultipartFile[] file;
	private List<Integer> cimageid;
	
	public Login(){
		
	}

	public Login(int id, String username, String password, Timestamp doe) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.doe = doe;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Timestamp getDoe() {
		return doe;
	}

	public void setDoe(Timestamp doe) {
		this.doe = doe;
	}
	public MultipartFile[] getFile() {
		return file;
	}

	public void setFile(MultipartFile[] file) {
		this.file = file;
	}

	public List<Integer> getCimageid() {
		return cimageid;
	}

	public void setCimageid(List<Integer> cimageid) {
		this.cimageid = cimageid;
	}

	@Override
	public String toString() {
		return "Login [id=" + id + ", username=" + username + ", password=" + password + ", doe=" + doe + "]";
	}
}