package com.bokaro.controller;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bokaro.dto.CandidateRegistrationDTO;
import com.bokaro.dto.QuestionDTO;
import com.bokaro.dto.TestSetDTO;
import com.bokaro.exception.ProgramException;
import com.bokaro.service.QuestionService;
import com.bokaro.service.TestSetService;

@Controller
@RequestMapping("/admin")
public class TestSetController {

	@Autowired
	private TestSetService testSetService;
	@Autowired
	private QuestionService questionService;
	
	@RequestMapping(value = "/create/testSet", method = RequestMethod.POST)
	public String create(@ModelAttribute TestSetDTO testSetDTO, BindingResult bindingResult,HttpServletRequest request,Locale locale,Model model, HttpServletResponse response)throws ProgramException{
		try{
			testSetDTO = testSetService.create(testSetDTO);
		}catch(DataIntegrityViolationException e){
			model.addAttribute("message","Sorry, "+testSetDTO.getQuestionSet()+" Question Set is already present !");
		}
		List<TestSetDTO> testSetDTOList = testSetService.findAll();
		model.addAttribute("testSetList", testSetDTOList);
		return "testPaperSet";
	}
	
	@RequestMapping(value = "/testSet", method = RequestMethod.GET)
	public String getResult(HttpServletRequest request,Locale locale,Model model, HttpServletResponse response)throws ProgramException{
		List<TestSetDTO> testSetDTOList = testSetService.findAll();
		model.addAttribute("testSetList", testSetDTOList);
		return "testPaperSet";
	}
	
	@RequestMapping(value = "/testSet/updateTime", method = RequestMethod.GET)
	public String updateTime(@RequestParam Long id,@RequestParam Long timeInMin,HttpServletRequest request,
			Locale locale,Model model, HttpServletResponse response)throws ProgramException{
		TestSetDTO testSetDTO = testSetService.updateTime(id,timeInMin);
		model.addAttribute("testSetDTO", testSetDTO);
		return "testPaperSet";
	}
	
	@RequestMapping(value = "/testSet/delete", method = RequestMethod.GET)
	public String deleteTestPaper(@RequestParam Long id,HttpServletRequest request,
			Locale locale,Model model,HttpServletResponse response)throws ProgramException{
		testSetService.delete(id);
		return "redirect:/admin/testSet";
	}
	
	@RequestMapping(value = "/isEnabled/testSet", method = RequestMethod.GET)
	public String isEnabled(@RequestParam Long id,HttpServletRequest request)throws ProgramException{
		TestSetDTO testSetDTO = testSetService.findById(id);
		if(testSetDTO.getIsEnabled()==true){
			testSetDTO.setIsEnabled(false);
			testSetDTO = testSetService.update(testSetDTO);
		}else{
			testSetDTO.setIsEnabled(true);
			testSetDTO = testSetService.update(testSetDTO);
		}
	    return "testPaperSet";
	}
	
	@RequestMapping(value = "/finish/{testSetId}", method = RequestMethod.GET)
	public String showTestSet(@PathVariable(value="testSetId")Long testSetId,HttpServletRequest request,
			Locale locale,Model model,HttpServletResponse response)throws ProgramException{
		List<QuestionDTO> questionList = questionService.findByTestSetId(testSetId.toString());
		TestSetDTO testSetDTO = testSetService.findById(testSetId);
		model.addAttribute("questionList", questionList);
		model.addAttribute("noOfSize", questionList.size());
		model.addAttribute("testSet", testSetDTO);
		return "questionPaper";
	}
}
