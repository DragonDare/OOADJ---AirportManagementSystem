package com.example.demo.controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.repository.RegisterRepository;
import com.example.demo.model.Register;
import com.example.demo.service.Jdbc;
import com.example.demo.service.RegisterService;


@Controller
//@SessionAttributes("users")
public class RegistrationController {
	
	@Autowired 
	RegisterService registerService;

	@Autowired
	RegisterRepository registerRepository;
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String showRegistration(ModelMap model) {
		Register register=new Register();
		model.put("register",register);
		return "register";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String RegistrationDetails(@ModelAttribute("register") Register register ,ModelMap model) {

		try
		{
			Connection con=Jdbc.JdbcConnect();
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select count(*) from register where user_name='"+register.getUsername()+"';");
			int val=1;
			while(rs.next())
			{
				val=rs.getInt("count(*)");
			}
			con.close();
			if(val>0)
			{
				return "redirect:/register";
			}
		}
		catch (Exception e)
		{
			return "redirect:/register";
		}


		registerRepository.save(register);
		model.put("success","Registered Successfully");
		return "redirect:/login";
	}
}
