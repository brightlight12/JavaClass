package com.cubicit;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller //use this for mapping.
public class LoginController1 {
	
	@Autowired
	private LoginService loginService;
	
	//  <form action="authUser" method="POST">
	@PostMapping({"/authUser"})
	public String execute(HttpServletRequest req){
		String username=req.getParameter("uname");
		String password=req.getParameter("pwd");
		if(loginService.isAuth(username, password)){
			return "home"; // ->> /home.jsp	
		}else{
			//Adding message in request scope so that we can access this message on jsp file
			req.setAttribute("message", "The username and password is not correct. Try again");
			return "auth"; // ->> /auth.jsp
		}
	}
	
//  <form action="authUser" method="POST">
	@GetMapping({"/oauth","/"})
	public String showPage(){
		return "auth"; // ->> /auth.jsp
	}

}
