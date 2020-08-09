package com.cubicit.controller;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cubicit.dao.LoginDao;


@Controller
public class LoginController2 {
	
	@Autowired
	private LoginDao loginDao;
	
	//<form action="myinput" method="POST">
		@PostMapping({"/myinput"})
		public String execute(HttpServletRequest req){
			String username=req.getParameter("uname");
			String password=req.getParameter("pwd");
			
			if(username.isEmpty() || password.isEmpty()) {
				req.setAttribute("dangermessage", "Username or Password cannot be null");
				return "input";
			} else {
				Login login = new Login();
				login.setPassword(password);
				login.setUsername(username);
				Timestamp timestamp=new Timestamp(new Date().getTime());
				login.setDoe(timestamp);
				
				loginDao.save(login);
				//Adding message in request scope so that we can access this message on jsp file
				req.setAttribute("message", "Username " + username + " has been added successfully!");
				return "input"; // ->> /input.jsp
				}
			}
		
		@GetMapping({"/myinput"})
		public String showPage(){
			return "input"; // ->> /input.jsp
		}
		
		@PostMapping({"/editlogin"})
		public String updateUsername(HttpServletRequest req, Model model){ //this annotation is reading did as integer from request parameter
			String username = req.getParameter("uname");
			String password = req.getParameter("pwd");
			int did = Integer.parseInt(req.getParameter("did"));
			Login login = new Login();
			login.setUsername(username);
			login.setPassword(password);
			login.setId(did);
			//Here we have to update the data inside database
			loginDao.updateById(login);
			
			
			model.addAttribute("message", "User login: " + username + " is updated");
			
			//Fetch all new records and add inside model to show on JSP
			List<Login> logins = loginDao.findAll();
			model.addAttribute("logindata", logins);
			return "logins"; // ->> /logins.jsp
		}
		
		
		@GetMapping({"/editlogin"})
		public String showEditPage(@RequestParam int did, Model model){ //this annotation is reading did as integer from request parameter
			Login logins = loginDao.findById(did);
			//model means request scope
			model.addAttribute("logindata", logins);
			return "editlogins"; // ->> /editlogins.jsp
		}
		
		@GetMapping("/deletelogin")
		public String deleteUserLogin(HttpServletRequest req){
			String username = req.getParameter("username");
			//deleting the data from the database
			loginDao.deleteByUserName(username);
			
			//This is showing remaining data from the database
			req.setAttribute("message", "Username: " +username + " is deleted");
			List<Login> loginlist = loginDao.findAll();
			req.setAttribute("logindata", loginlist);
			return "logins"; // ->> /logins.jsp
		}
		
		@GetMapping({"/showlogin"})
		public String showLogins(HttpServletRequest req){
			List<Login> loginli = loginDao.findAll();
			req.setAttribute("logindata", loginli);
			return "logins"; // ->> /logins.jsp
		}
}