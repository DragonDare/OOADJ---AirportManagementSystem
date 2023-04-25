package com.example.demo.controller;

import  com.example.demo.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.model.Login;
import org.springframework.web.bind.annotation.RestController;


import javax.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;

@Controller
//@SessionAttributes("users")
public class LoginController {

	@Autowired
    LoginService service;


	ModelMap global_model=new ModelMap();

	@RequestMapping(value="/",method = RequestMethod.GET)
	public String showWelcomePage(ModelMap model) {
		return "redirect:/login";
	}

	@RequestMapping(value="/login",method = RequestMethod.GET)
	public String showLoginPage(ModelMap model) {
		Login login=new Login();
		model.put("login",login);

		return "login";
	}


	@RequestMapping(value="/login",method = RequestMethod.POST)
	public String showWelcomePage(ModelMap model, @ModelAttribute("login") Login login, HttpServletRequest request) {
		if(login == null ){
			System.out.println();
		}
		System.out.println(login.getUsername());
		System.out.println(login.getPassword());

//		Register register = (Register) model.getAttribute("users");
//		System.out.println(register.getEmail());
		boolean isValidateUser = false;
		try {
			isValidateUser = service.validateUser(login.getUsername(), login.getPassword());
		} catch (SQLException e) {

			System.out.println(login.getUsername());
			System.out.println(login.getPassword());
			throw new RuntimeException(e);
		}
		if(!isValidateUser) {
			model.put("errorMessage", "Invalid Credentials");
			return "login";
		}
		int usr_id;
		try{
			usr_id= service.getUsrId(login.getUsername());
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}


		HttpSession session= request.getSession();
		session.setAttribute("uid",usr_id);
		return "redirect:/home";
	}

	@RequestMapping(value="/logout",method = RequestMethod.GET)
	public String log_out(HttpSession session) {
		session.invalidate();
		return "redirect:/login";
	}

}
