package com.cubicit.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
	
	// <form action="authUser" method="post">
	@PostMapping({"/authUser"})
	public String execute(HttpServletRequest req) {
		String username = req.getParameter("uname");
		String password = req.getParameter("pwd");
		if("jack".equals(username) && "jill".equals(password)) {
			return "home"; //home.jsp
		} else {
			//Adding message in request scope so that we can access this message in the jsp file
			req.setAttribute("message", "The username and password is not correct.");
			return "auth"; //auth.jsp
		}
	}

	@GetMapping({"/oauth"})
	public String showPage() {
			return "auth"; //this will show auth.jsp page if accessed from url directly
		}
}
