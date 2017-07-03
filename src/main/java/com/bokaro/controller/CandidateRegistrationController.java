package com.bokaro.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bokaro.custom.repository.CandidateCustomRepository;
import com.bokaro.dto.CandidateRegistrationDTO;
import com.bokaro.dto.CandidateTestSetConfigurationDTO;
import com.bokaro.dto.TestSetDTO;
import com.bokaro.service.CandidateRegistrationService;
import com.bokaro.service.CandidateTestSetConfigurationService;
import com.bokaro.service.TestSetService;

@Controller
@RequestMapping("/admin")
public class CandidateRegistrationController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CandidateRegistrationController.class);
	
	@Autowired
	private CandidateRegistrationService candidateRegistrationService;
	@Autowired
	private TestSetService testSetService;
	@Autowired
	private CandidateTestSetConfigurationService candidateTestSetConfigurationService;
	@Autowired
	private CandidateCustomRepository candidateCustomRepository;
	
	@RequestMapping(value="/candidateRegistration", method=RequestMethod.POST)
	public String create(@ModelAttribute CandidateRegistrationDTO candidateRegistrationDTO, BindingResult bindingResult,
			HttpServletRequest request,Locale locale,Model model){
		candidateRegistrationDTO = candidateRegistrationService.create(candidateRegistrationDTO);
		if(candidateRegistrationDTO.getId() == null || candidateRegistrationDTO.equals("")){
			request.setAttribute("msg", "MODE_ERROR");
			model.addAttribute("message","Condidate Regiatration Failed !");
			request.setAttribute("mode", "MODE_REGISTRATION");
		}else{
			request.setAttribute("msg", "MODE_SUCCESS");
			model.addAttribute("message","Candidate Regiatration Successfully !");
			request.setAttribute("mode", "MODE_REGISTRATION");
			model.addAttribute("candidateRegistrationDTO", candidateRegistrationDTO);

		}
		return "home";
	}
	
	@RequestMapping(value = "/candidateList", method = RequestMethod.GET)
	public String condidateList(HttpServletRequest request,Locale locale,Model model){
		List<CandidateRegistrationDTO> candidateRegistrationDTOs = candidateRegistrationService.findAll();
		request.setAttribute("mode", "MODE_CADIDATELIST");
		model.addAttribute("candidateList", candidateRegistrationDTOs);
		return "home";
	}
	
	
	@RequestMapping(value="/deleteCandidate", method = RequestMethod.GET)
	public String deleteCandidate(@RequestParam Long id, HttpServletRequest request,Locale locale,Model model){
		candidateRegistrationService.delete(id);
		return "redirect:/admin/candidateList";
	}
	
	@RequestMapping(value="/candidate/enable", method=RequestMethod.GET)
	public String getIsEnableData(@RequestParam String enable,HttpServletRequest request,Locale locale,Model model){
			List<CandidateRegistrationDTO> candidateRegistrationDTOs = candidateRegistrationService.findByIsEnable(enable);
		model.addAttribute("candidateList", candidateRegistrationDTOs);
		request.setAttribute("mode", "MODE_CADIDATELIST");
		return "home";
		
	}
	
	@RequestMapping(value = "/permission", method = RequestMethod.GET)
	public String Submit(@RequestParam Long id,HttpServletRequest request) {
		CandidateRegistrationDTO candidateRegistrationDTO = candidateRegistrationService.findById(id);
		if(candidateRegistrationDTO.getIsEnabled()==true){
			candidateRegistrationDTO.setIsEnabled(false);
			candidateRegistrationDTO = candidateRegistrationService.update(candidateRegistrationDTO);
		}else{
			candidateRegistrationDTO.setIsEnabled(true);
			candidateRegistrationDTO = candidateRegistrationService.update(candidateRegistrationDTO);
		}
	    return "home";
	}
	
	@RequestMapping(value="/assignTo", method=RequestMethod.GET)
	public String getCandidateList(@RequestParam Long testSetId,HttpServletRequest request,Locale locale,Model model){
		List<CandidateRegistrationDTO> candidateRegistrationDTOs = candidateRegistrationService.findAll();
		ArrayList<String> emailId = new ArrayList<>();
		for(CandidateRegistrationDTO registrationDTO : candidateRegistrationDTOs){
			emailId.add("'"+registrationDTO.getEmail()+"'");
		}
		List<CandidateRegistrationDTO> candidateRegistrationDTOs2 = candidateCustomRepository.findByTestSetId(testSetId);
		TestSetDTO testSetDTO = testSetService.findById(testSetId);
		model.addAttribute("candidateList", candidateRegistrationDTOs);
		model.addAttribute("candidateListOfTestSet", candidateRegistrationDTOs2);
		model.addAttribute("testSet", testSetDTO);
		model.addAttribute("email", emailId);
		return "assignTo";
		
	}
	
	@RequestMapping(value = "/searchCandidate", method = RequestMethod.POST)
	public String searchCandidate(@RequestParam("name") String name,@RequestParam("email") String email,
			@RequestParam("mobileNumber") String mobileNumber,@RequestParam("date") String date,HttpServletRequest request,Locale locale,Model model){
		List<CandidateRegistrationDTO> candidateRegistrationDTOs = candidateRegistrationService.getCandidateDetails(name,email,mobileNumber,date);
//		List<CandidateRegistrationDTO> candidateRegistrationDTOs = candidateRegistrationService.findAll();
		request.setAttribute("mode", "MODE_CADIDATELIST");
		model.addAttribute("candidateList", candidateRegistrationDTOs);
		return "home";
	}
	
	@RequestMapping(value="/candidate/assignTo", method=RequestMethod.POST)
	public String assignToCandidate(@RequestParam Long testSetId,@RequestParam String email,HttpServletRequest request,Locale locale,Model model){
		List<CandidateTestSetConfigurationDTO> candidateTestSetConfigurationDTOs = candidateTestSetConfigurationService.getDataByCandidateId(testSetId,email);
//		TestSetDTO testSetDTO = testSetService.findById(testSetId);
		model.addAttribute("candidateTestSetConfigurationList", candidateTestSetConfigurationDTOs);
//		model.addAttribute("testSet", testSetDTO);
		return "redirect:/admin/assignTo?testSetId="+testSetId;
		
	}
	@RequestMapping(value="/registration/state", method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<List<String>> cities(@RequestParam String state,HttpServletRequest request,Locale locale,Model model){
		List<String> cities = new ArrayList<String>();
		cities.add("----------------Select----------------");
		if(state.equalsIgnoreCase("Utter Pradesh")){
			cities.add("Agra");
			cities.add("Aligarh");
			cities.add("Allahabad");
			cities.add("Amethi");
			cities.add("Ambedkar Nagar");
			cities.add("Azamgarh");
			cities.add("Bahraich");
			cities.add("Ballia");
			cities.add("Bareilly");
			cities.add("Basti");
			cities.add("Bijnor");
			cities.add("Bulandshahr");
			cities.add("Deoria");
			cities.add("Etawah");
			cities.add("Fatehpur");
			cities.add("Firozabad");
			cities.add("Gazipur");
			cities.add("Ghaziabad");
			cities.add("Gonda");
			cities.add("Gorakhpur");
			cities.add("Greater Noida");
			cities.add("Hapur");
			cities.add("Hardoi");
			cities.add("Hathras");
			cities.add("Jaunpur");
			cities.add("Jhashi");
			cities.add("Kanpur");
			cities.add("Lucknow");
			cities.add("Mathura");
			cities.add("Mau");
			cities.add("Meerut");
			cities.add("Mirzapur");
			cities.add("Moradabad");
			cities.add("Muzaffarnagar");
			cities.add("Noida");
			cities.add("Raebareli");
			cities.add("Rampur");
			cities.add("Saharanpur");
			cities.add("Shahjahanpur");
			cities.add("Unnao");
			cities.add("Varanasi");
		}else if(state.equalsIgnoreCase("Madhay Pradesh")){
			cities.add("Betul");
			cities.add("Bhind");
			cities.add("Bhopal");
			cities.add("Burhanpur");
			cities.add("Chhatarpur");
			cities.add("Chhindwara");
			cities.add("Damoh");
			cities.add("Datia");
			cities.add("Guna");
			cities.add("Gwalior");
			cities.add("Hoshangabad");
			cities.add("Indor");
			cities.add("Jhabua");
			cities.add("Jabalpur");
			cities.add("Katni");
			cities.add("Khandwa");
			cities.add("Khargone");
			cities.add("Mandsaur");
			cities.add("Neemuch");
			cities.add("Pithampur");
			cities.add("Ratlam");
			cities.add("Rewa");
			cities.add("Sagar");
			cities.add("Satna");
			cities.add("Seoni");
			cities.add("Singrauli");
			cities.add("Shivpuri");
			cities.add("Ujjain");
			cities.add("Vidisha");
		}else if(state.equalsIgnoreCase("Jharkhand")){
			cities.add("Bokaro");
			cities.add("Dhanbad");
			cities.add("Deoghar");
			cities.add("Giridih");
			cities.add("Hazaribagh");
			cities.add("Jamshedpur");
			cities.add("Ramgarh");
			cities.add("Ranchi");
			cities.add("Palamu");
		}else if(state.equalsIgnoreCase("Karnataka")){
			cities.add("Bangalore");
			cities.add("Mangalore");
			cities.add("Mysore");
		}else if(state.equalsIgnoreCase("Bihar")){
			cities.add("Arrah");
			cities.add("Aurangabad");
			cities.add("Begusarai");
			cities.add("Bettiah");
			cities.add("Bhagalpur");
			cities.add("Bhojpur");
			cities.add("Buxar");
			cities.add("Chhapra");
			cities.add("Darbhanga");
			cities.add("Gaya");
			cities.add("Hajipur");
			cities.add("Jehanabad");
			cities.add("Katihar");
			cities.add("Madhubani");
			cities.add("Munger");
			cities.add("Muzaffarpur");
			cities.add("Nalanda");
			cities.add("Nawada");
			cities.add("Patana");
			cities.add("Purnea");
			cities.add("Rajgir");
			cities.add("Saharsa");
			cities.add("Sitamarhi");
			cities.add("West Champaran");
		}else if(state.equalsIgnoreCase("Maharastra")){
			cities.add("Akola");
			cities.add("Amravati");
			cities.add("Badlapur");
			cities.add("Kolhapur");
			cities.add("Khandala");
			cities.add("Karanja");
			cities.add("Malegaon");
			cities.add("Mumbai");
			cities.add("Nagpur");
			cities.add("Nashik");
			cities.add("Pune");
			cities.add("Ratnagiri");
			cities.add("Solapur");
			cities.add("Thane");
		}else if(state.equalsIgnoreCase("Bengal")){
			cities.add("Asansol");
			cities.add("Bardhaman");
			cities.add("Darjeeling");
			cities.add("Durgapur");
			cities.add("Kharagpur");
			cities.add("Kolkata");
			cities.add("Haldia");
			cities.add("Haora");
			cities.add("Hooghly");
			cities.add("Malda");
			cities.add("Murshidabad");
			cities.add("Nadia");
			cities.add("Purulia");
			cities.add("Shiliguri");
		}
		else if(state.equalsIgnoreCase("Chhattisgarh")){
			cities.add("Ambikapur");
			cities.add("Bhilai");
			cities.add("Bilaspur");
			cities.add("Chirmiri");
			cities.add("Dhamtari");
			cities.add("Durg");
			cities.add("Jagdalpur");
			cities.add("Korba");
			cities.add("Mahasamund");
			cities.add("Nandgao");
			cities.add("Pakhanjore");
			cities.add("Raigarh");
			cities.add("Raipur");
			cities.add("Rajnandgaon");
		}
		return new ResponseEntity<>(cities, HttpStatus.OK);
	}
}
