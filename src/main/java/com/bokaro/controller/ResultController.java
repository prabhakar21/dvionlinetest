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
import org.springframework.web.bind.annotation.RequestParam;

import com.bokaro.dto.CandidateRegistrationDTO;
import com.bokaro.dto.ResultDTO;
import com.bokaro.dto.TestPackageDTO;
import com.bokaro.service.CandidateRegistrationService;
import com.bokaro.service.ResultService;
import com.bokaro.service.TestPackageService;

@Controller
public class ResultController {

	@Autowired
	private ResultService resultService;
	@Autowired
	private TestPackageService testPackageService;
	@Autowired
	private CandidateRegistrationService candidateRegistrationService;
	
	@RequestMapping(value = "/user/testResult", method = RequestMethod.POST)
	public String getResult(@ModelAttribute ResultDTO result,BindingResult bindingResult,HttpServletRequest request,
			Locale locale,Model model, HttpServletResponse response){
		result = resultService.saveResult(result);
		return "redirect:/user/show/testResult?id="+result.getId();
	}
	
	@RequestMapping(value = "/user/show/testResult", method = RequestMethod.GET)
	public String showResult(@RequestParam Long id,HttpServletRequest request,
			Locale locale,Model model, HttpServletResponse response){
		ResultDTO resultDTO = resultService.findById(id);
		Long countTestResult = resultService.countByCandidateId(resultDTO.getCandidateId());
		CandidateRegistrationDTO candidateRegistrationDTO = candidateRegistrationService.findById(resultDTO.getCandidateId());
		if(candidateRegistrationDTO.getIsPackage()){
			TestPackageDTO testPackageDTO = testPackageService.findActivePackage(resultDTO.getCandidateId());
			if(testPackageDTO != null){
				if(testPackageDTO.getNoOfTest() > countTestResult){
					model.addAttribute("testLeft", testPackageDTO.getNoOfTest()-countTestResult);
				}else{
					candidateRegistrationDTO = candidateRegistrationService.getDisable(candidateRegistrationDTO);
					model.addAttribute("testLeft", new Long(0));
					model.addAttribute("message","Username has been disable.");
				}
			}else{
				model.addAttribute("message","Username has been disable.");
			}
		}else{
			candidateRegistrationDTO = candidateRegistrationService.getDisable(candidateRegistrationDTO);
		}
		model.addAttribute("finalObject", resultDTO);
		return "testResult";
	}
	
	@RequestMapping(value = "/admin/testResult", method = RequestMethod.GET)
	public String candidateTestResult(HttpServletRequest request,Model model){
		List<ResultDTO> resultList = resultService.findAll();
		model.addAttribute("resultList", resultList);
		return "candidateTestResult";
	}
}
