package com.cognizant.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cognizant.Service.Validation;
import com.cognizant.model.User;

@Controller
public class UserController {

	User user=new User();
	Validation service=new Validation();
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String getLogin(@ModelAttribute("user")User user)
	{
		return "login";
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String showLogin(@ModelAttribute("user")User user,ModelMap model)
	{
		
		String password=user.getPassword();
		boolean isValid=service.userValidate(password);
		if(isValid)
		{
			return "welcome";
		}
		else
		{
			model.addAttribute("errormessage","Invalid Credentials");
			return "login";
		}
	}
}
