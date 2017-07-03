package com.bokaro.controller;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bokaro.dto.TestPackageDTO;
import com.bokaro.exception.ProgramException;
import com.bokaro.service.TestPackageService;

@Controller
@RequestMapping("/admin")
public class TestPackageController {

	@Autowired
	private TestPackageService testPackageService;
	
	@RequestMapping(value="/assignPackage", method=RequestMethod.POST)
	public String assignPackage(@ModelAttribute TestPackageDTO testPackageDTO, BindingResult bindingResult,
			HttpServletRequest request,Locale locale,Model model,RedirectAttributes redirectAttributes)throws ProgramException{
		
		Long candidateId = testPackageDTO.getCandidateId();
		testPackageDTO = testPackageService.create(testPackageDTO);
		if(testPackageDTO ==  null){
			model.addAttribute("error","You can not assign new package for "+candidateId);
			request.setAttribute("mode", "MODE_CADIDATELIST");
			return "redirect:/admin/candidateList";	
		}
		request.setAttribute("mode", "MODE_REGISTRATION");
		return "home";	
	}
	
	@RequestMapping(value = "/activePackageDetails", method = RequestMethod.GET)
	public String activepacakge(HttpServletRequest request,Locale locale,Model model, HttpServletResponse response)throws ProgramException{
		List<TestPackageDTO> testPackageDTOList = testPackageService.findActivePackage();
		model.addAttribute("testPackageList", testPackageDTOList);
		return "testPackage";
	}
	
	@RequestMapping(value = "/expirePackageDetails", method = RequestMethod.GET)
	public String expirePackage(HttpServletRequest request,Locale locale,Model model, HttpServletResponse response)throws ProgramException{
		List<TestPackageDTO> testPackageDTOList = testPackageService.findExpirePackage();
		model.addAttribute("testPackageList", testPackageDTOList);
		return "testPackage";
	}
	
	@RequestMapping(value = "/assignPackageDetails", method = RequestMethod.GET)
	public String assignPackage(HttpServletRequest request,Locale locale,Model model, HttpServletResponse response)throws ProgramException{
		List<TestPackageDTO> testPackageDTOList = testPackageService.findAssignPackage();
		model.addAttribute("testPackageList", testPackageDTOList);
		return "testPackage";
	}
}
