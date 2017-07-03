package com.bokaro.controller;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bokaro.dto.UpdateNotificationDTO;
import com.bokaro.exception.ProgramException;
import com.bokaro.service.UpdateNotificationService;

@Controller
@RequestMapping("/admin")
public class UpdateNotificationController {

	@Autowired
	private UpdateNotificationService updateNotificationService;
	
	@RequestMapping(value = "/notification", method = RequestMethod.GET)
	public String notification(HttpServletRequest request,Model model,Locale locale) throws ProgramException{
		List<UpdateNotificationDTO> updateNotifications = updateNotificationService.findAllOrderByIdDesc();
		request.setAttribute("mode", "MODE_NOTIFICATION");
		model.addAttribute("updateNotification", updateNotifications);
		return "notification";
	}
	
	@RequestMapping(value = "/update/notification", method = RequestMethod.POST)
	public String updateNotification(@RequestParam String message,HttpServletRequest request,Model model,Locale locale) throws ProgramException{
		UpdateNotificationDTO updateNotificationDTO = updateNotificationService.create(message);
		return "redirect:/admin/notification";
	}
	
	@RequestMapping(value = "/deleteNotification", method = RequestMethod.GET)
	public String deleteNotification(@RequestParam Long id,HttpServletRequest request,Model model,Locale locale) throws ProgramException{
		updateNotificationService.delete(id);
		return "redirect:/admin/notification";
	}
}
