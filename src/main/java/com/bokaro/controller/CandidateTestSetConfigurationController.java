package com.bokaro.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bokaro.service.CandidateTestSetConfigurationService;

@Controller
@RequestMapping("/admin")
public class CandidateTestSetConfigurationController {
	
	@Autowired
	private CandidateTestSetConfigurationService candidateTestSetConfigurationService;
	
	@RequestMapping(value="/deleteCandidateTestSetConfiguration/{candidateTestSetConfigurationId}/{testSetId}", method = RequestMethod.GET)
	public String deleteCandidate(@PathVariable(value="candidateTestSetConfigurationId")Long candidateTestSetConfigurationId,
			@PathVariable(value="testSetId")Long testSetId, HttpServletRequest request,Locale locale,Model model){
		candidateTestSetConfigurationService.delete(candidateTestSetConfigurationId);
		return "redirect:/admin/assignTo?testSetId="+testSetId;
	}

}
