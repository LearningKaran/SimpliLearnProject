package com.example.SportyShoes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.SportyShoes.entities.User;
import com.example.SportyShoes.services.UserService;

@Controller
public class LoginController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String welcomePage(ModelMap model)
	{
		return showview(model);
	}
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String showview(ModelMap model)
	{
		model.addAttribute("message", "Welcome!!");
		return ("login");
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String handleLogin(@RequestParam (value="username", required = true) String username, @RequestParam(value="password", required = true) String password, ModelMap model)
	{
		User user;
		try {
		 user=userService.getUserByName(username);
		}
		catch(Exception ex)
		{
			model.addAttribute("message", "Error:User Not Found!!");
			return ("login");
		}
		
		if(userService.confirmUserPassword(user, password))
		{
			model.addAttribute("message", "Login Success!!");
		}
		
		else
		{
			model.addAttribute("message", "Invalid Password. Please Try again!!");
		}
		return ("login");
	}
}
