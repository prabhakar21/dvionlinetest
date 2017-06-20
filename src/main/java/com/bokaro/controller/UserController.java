package com.bokaro.controller;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bokaro.dto.CandidateRegistrationDTO;
import com.bokaro.dto.QuestionDTO;
import com.bokaro.dto.TestPackageDTO;
import com.bokaro.dto.TestSetDTO;
import com.bokaro.service.CandidateRegistrationService;
import com.bokaro.service.QuestionService;
import com.bokaro.service.ResultService;
import com.bokaro.service.TestPackageService;
import com.bokaro.service.TestSetService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private QuestionService questionService;
	@Autowired
	private TestSetService testSetService;
	@Autowired
	private ResultService resultService;
	@Autowired
	private TestPackageService testPackageService;
	@Autowired
	private CandidateRegistrationService candidateRegistrationService;
	
	@RequestMapping(value = "/instruction", method = RequestMethod.GET)
	public String getInstruction(@RequestParam Long candidateId,HttpServletRequest request,Locale locale,Model model){
		return "instruction";
	}
	
	@RequestMapping(value = "/testSetForUser", method = RequestMethod.GET)
	public String testSetForUser(HttpServletRequest request,Locale locale,Model model){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetail = (UserDetails) auth.getPrincipal();
		String username = userDetail.getUsername();
		CandidateRegistrationDTO candidateRegistrationDTO = candidateRegistrationService.findByUserName(username);
		TestPackageDTO testPackageDTO = null;
		Long countTestResult = null;
		try{
			if(candidateRegistrationDTO.getIsPackage()){
				countTestResult = resultService.countByCandidateId(candidateRegistrationDTO.getId());
				testPackageDTO = testPackageService.findActivePackage(candidateRegistrationDTO.getId());
				if(testPackageDTO == null){
					model.addAttribute("message"," No any Test Set for : "+candidateRegistrationDTO.getFullname());
				}else if(testPackageDTO.getNoOfTest() > countTestResult){
					model.addAttribute("testLeft", testPackageDTO.getNoOfTest()-countTestResult);
				}else{
					model.addAttribute("testLeft", new Long(0));
					model.addAttribute("message"," It is one time persmission to give the test !");
				}
			}else{
				model.addAttribute("message"," It is one time persmission to give the test !");
			}
			List<TestSetDTO> testSetDTOs = testSetService.findByUsername(username);
			model.addAttribute("testSetList", testSetDTOs);
		}catch (Exception e) {
			model.addAttribute("candidateRegistration", candidateRegistrationDTO);
			model.addAttribute("message"," No any Test Set for : ");
		}
		return "testSetForUser";
	}
	
	@RequestMapping(value = "/testStart/{testSetId}/{timeInMin}", method = RequestMethod.GET)
	public String getTestPaper(@PathVariable(value="testSetId")Long testSetId,@PathVariable(value="timeInMin")Long timeInMin,HttpServletRequest request,Locale locale,Model model){
		List<QuestionDTO> questionList = questionService.findByTestSetId(testSetId.toString());
		model.addAttribute("questionList", questionList);
		model.addAttribute("totalQuestion", questionList.size());
		model.addAttribute("totalTime", timeInMin*60);
		model.addAttribute("testSetId", testSetId);
		return "testPaper";
	}
	
}
