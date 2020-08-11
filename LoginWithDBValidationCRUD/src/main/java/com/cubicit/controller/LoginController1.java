package com.cubicit.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.cubicit.dao.LoginDao;

@Controller //use this for mapping.
public class LoginController1 {
	
	@Autowired
	private LoginDao loginDao;
	
	//  <form action="authUser" method="POST">
	@PostMapping({"/authUser"})
	public String execute(HttpServletRequest req){
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		if(loginDao.isAuth(username, password)){
			return "home"; // ->> /home.jsp	
		}else{
			//Adding message in request scope so that we can access this message on jsp file
			req.setAttribute("message", "The username or password is incorrect.");
			return "auth"; // ->> /auth.jsp
		}
	}
	
//  <form action="authUser" method="POST">
	@GetMapping({"/oauth","/"})
	public String showPage(){
		return "auth"; // ->> /auth.jsp
	}

}