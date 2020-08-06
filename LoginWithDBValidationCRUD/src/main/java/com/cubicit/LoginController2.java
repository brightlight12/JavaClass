package com.cubicit;

import java.sql.Timestamp;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class LoginController2 {
	
	@Autowired
	private LoginService loginService;
	
	//<form action="myinput" method="POST">
		@PostMapping({"/myinput"})
		public String execute(HttpServletRequest req){
			String username=req.getParameter("uname");
			String password=req.getParameter("pwd");
			
			Login login=new Login();
			login.setPassword(password);
			login.setUsername(username);
			Timestamp timestamp=new Timestamp(new Date().getTime());
			login.setDoe(timestamp);
			
			loginService.save(login);
			//Adding message in request scope so that we can access this message on jsp file
			req.setAttribute("message", "Record is added successfully!!!!!!!!!!!!!!!!!!");
			return "input"; // ->> /auth.jsp
		}
		
		@GetMapping("/myinput")
		public String showPage(){
			return "input"; // ->> /auth.jsp
		}
}
