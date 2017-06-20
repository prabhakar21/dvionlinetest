package com.bokaro.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bokaro.exception.ProgramException;
import com.bokaro.service.UserService;

@Controller
public class PasswordController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/user/changePassword", method = RequestMethod.GET)
	public String newPassForUser(HttpServletRequest request,Model model,Locale locale){
		return "changePasswordForUser";
	}
	
	@RequestMapping(value = "/user/create/newPassword", method = RequestMethod.POST)
	public String changePassForUser(@RequestParam String newPassword, HttpServletRequest request,
			Model model,Locale locale){
		userService.changePassword(newPassword);
		return "redirect:/user/instruction";
	}
	
	@RequestMapping(value = "/admin/changePassword", method = RequestMethod.GET)
	public String newPassForAdmin(HttpServletRequest request,Model model,Locale locale) throws ProgramException{
		return "changePasswordForAdmin";
	}
	
	@RequestMapping(value = "/admin/create/newPassword", method = RequestMethod.POST)
	public String changePassForAdmin(@RequestParam String newPassword, HttpServletRequest request,
			Model model,Locale locale){
		userService.changePassword(newPassword);
		return "redirect:/admin/registration";
	}
}
