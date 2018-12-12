package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.domain.Users;
import com.example.demo.service.CustomerService;

@Controller
public class LoginController {
	@Autowired
	private CustomerService service;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public @ResponseBody List<Users> read(Model model)
	{
		
		return service.findAll();
	}
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public  @ResponseBody Users  insert(Model model,@RequestParam("username") String username, @RequestParam("password") String password)
	{
		
		Users user = new Users();
		user.setUsername(username);
		user.setPassword(password);
		return service.save(user);
	}
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public @ResponseBody void delete(@PathVariable("id") int id)
	{
		service.deleteById(id);
	}
	
	@RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
	public  @ResponseBody Users  update(Model model,@PathVariable("id") int id,@RequestParam("username") String username, @RequestParam("password") String password)
	{
		
		Users user = new Users();
		user.setUsername(username);
		user.setPassword(password);
		return service.save(user);
	}
	
	
}
