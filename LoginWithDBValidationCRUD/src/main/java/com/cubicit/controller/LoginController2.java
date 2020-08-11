package com.cubicit.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cubicit.dao.LoginDao;


@Controller
public class LoginController2 {
	
	@Autowired
	private LoginDao loginDao;
	
	//<form action="myinput" method="POST">
		@PostMapping({"/myinput"})
		public String execute(@ModelAttribute Login login, Model model){
				Timestamp timestamp=new Timestamp(new Date().getTime());
				login.setDoe(timestamp);
				
				loginDao.save(login);
				//Adding message in request scope so that we can access this message on jsp file
				model.addAttribute("message", "Username has been added successfully!");
				return "input"; // ->> /input.jsp
				}
		
		@GetMapping({"/myinput"})
		public String showPage(){
			return "input"; // ->> /input.jsp
		}
		
		@PostMapping({"/editlogin"})
		public String updateUsername(HttpServletRequest req, Model model){ //this annotation is reading did as integer from request parameter
			String username = req.getParameter("username");
			String password = req.getParameter("password");
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
		
		@GetMapping("/deletebyid")
		public String deleteById(HttpServletRequest req){
			String dbid = req.getParameter("id");
			//deleting the data from the database
			loginDao.deleteById(Integer.parseInt(dbid));
			
			//This is showing remaining data from the database
			req.setAttribute("message", "ID: " + dbid + " is deleted");
			List<Login> loginlist = loginDao.findAll();
			req.setAttribute("logindata", loginlist);
			return "logins"; // ->> /logins.jsp
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
		
		//<img src="loadphoto?dbid=44"/>
		@GetMapping({"/loadphoto"})
		public void renderPhoto(@RequestParam int dbid,HttpServletResponse resp) throws IOException{
			byte[] photo = loginDao.findPhotoById(dbid);
			resp.setContentType("image/jpeg");
			ServletOutputStream outputStream = resp.getOutputStream(); //reference of the body of the response
			if(photo!=null){
				outputStream.write(photo);
				outputStream.flush();
				outputStream.close();	
			}
		}
}