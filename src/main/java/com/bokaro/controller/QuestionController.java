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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.bokaro.dto.QuestionDTO;
import com.bokaro.dto.TestSetDTO;
import com.bokaro.exception.ProgramException;
import com.bokaro.service.QuestionService;
import com.bokaro.service.TestSetService;

@Controller
public class QuestionController {

	@Autowired
	private QuestionService questionService;
	@Autowired
	private TestSetService testSetService;
	
	@RequestMapping(value="/admin/createQuestion", method=RequestMethod.POST)
	public String createQuestion(@ModelAttribute QuestionDTO questionDTO,BindingResult bindingResult,@RequestParam("testSetId") String testSetId,
			@RequestParam("files") MultipartFile[] files,@RequestParam("language") String language,
			HttpServletRequest request,Locale locale,Model model) throws ProgramException{
//		String rootPath = System.getProperty("user.home");
		Long questionId = questionDTO.getId();
		String rootPath = request.getRealPath("/");
		questionDTO = questionService.create(questionDTO,files,language,rootPath,testSetId);
		Long totalQuestion = questionService.getNumberOfQuestion(testSetId);
		TestSetDTO testSetDTO = testSetService.findById(new Long(testSetId));
		model.addAttribute("testSetId", testSetId);
		model.addAttribute("totalQuestion", totalQuestion);
		model.addAttribute("testSet", testSetDTO);
		if(questionId != null){
			return "redirect:/showTestPaper?id="+testSetId;
		}
		return "questionForm";
		
	}
	
	@RequestMapping(value="/admin/questionPaper", method=RequestMethod.GET)
	public String create(HttpServletRequest request,Locale locale,Model model){
		List<QuestionDTO> questionList = questionService.findAll();
		model.addAttribute("questionList", questionList);
		model.addAttribute("noOfSize", questionList.size());
		return "questionPaper";
		
	}
	
	@RequestMapping(value="/admin/updateQuestion/{questionId}", method=RequestMethod.GET)
	public String editQuestion(@PathVariable(value="questionId")Long questionId,HttpServletRequest request,Locale locale,Model model){
		QuestionDTO questionDTO = questionService.findById(questionId);
		model.addAttribute("question", questionDTO);
		return "questionForm";
		
	}
	
	@RequestMapping(value = "/showTestPaper", method = RequestMethod.GET)
	public String showTestPaper(@RequestParam Long id,HttpServletRequest request,
			Locale locale,Model model,HttpServletResponse response)throws ProgramException{
		List<QuestionDTO> questionList = questionService.findByTestSetId(id.toString());
		TestSetDTO testSetDTO = testSetService.findById(id);
		model.addAttribute("questionList", questionList);
		model.addAttribute("noOfSize", questionList.size());
		model.addAttribute("testSet", testSetDTO);
		return "questionPaper";
		
	}
	
	@RequestMapping(value = "/admin/editQuestion/{questionId}", method = RequestMethod.GET)
	public String editQuestion(@PathVariable(value="questionId")Long questionId,HttpServletRequest request,
			Locale locale,Model model,HttpServletResponse response)throws ProgramException{
		QuestionDTO questionDTO = questionService.findById(questionId);
		TestSetDTO testSetDTO = testSetService.findById(new Long(questionDTO.getTestSetId()));
		Long totalQuestion = questionService.getNumberOfQuestion(testSetDTO.getId().toString());
		model.addAttribute("question", questionDTO);
		model.addAttribute("testSet", testSetDTO);
		model.addAttribute("testSetId", testSetDTO.getId());
		model.addAttribute("totalQuestion", totalQuestion);
		return "questionForm";
	}
	
	@RequestMapping(value = "/addQuestion/{testSetId}", method = RequestMethod.GET)
	public String addQuestion(@PathVariable(value="testSetId")Long testSetId,HttpServletRequest request,
			Locale locale,Model model,HttpServletResponse response)throws ProgramException{
		TestSetDTO testSetDTO = testSetService.findById(testSetId);
		Long totalQuestion = questionService.getNumberOfQuestion(testSetId.toString());
		model.addAttribute("totalQuestion", totalQuestion);
		model.addAttribute("testSet", testSetDTO);
		return "questionForm";
	}
}
