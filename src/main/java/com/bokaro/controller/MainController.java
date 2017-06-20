package com.bokaro.controller;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bokaro.dto.CandidateRegistrationDTO;
import com.bokaro.dto.ContactUsDTO;
import com.bokaro.dto.TestSetDTO;
import com.bokaro.dto.UpdateNotificationDTO;
import com.bokaro.dto.UserDTO;
import com.bokaro.exception.ProgramException;
import com.bokaro.repository.UserRolesRepository;
import com.bokaro.service.CandidateRegistrationService;
import com.bokaro.service.ContactService;
import com.bokaro.service.TestSetService;
import com.bokaro.service.UpdateNotificationService;
import com.bokaro.service.UserService;

@Controller
public class MainController {
	private static final Logger LOGGER = LoggerFactory.getLogger(CandidateRegistrationController.class);
	
	@Autowired
	private UserRolesRepository userRolesRepository;
	@Autowired
	private CandidateRegistrationService candidateRegistrationService;
	@Autowired
	private UserService userService;
	@Autowired
	private UpdateNotificationService updateNotificationService;
	@Autowired
	private TestSetService testSetService;
	@Autowired
	private ContactService contactService;
//	@Autowired(required=true)
//	private EmailServiceFacade emailService;
//	@Autowired
//	private NotificationService notificationService;
	
	@RequestMapping("/")
	public String welcome() {
		return "index";
	}
	
	@RequestMapping(value = { "/", "/welcome**" }, method = RequestMethod.GET)
	public ModelAndView defaultPage(){
		ModelAndView model = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetail = (UserDetails) auth.getPrincipal();
		String username = userDetail.getUsername();
		List<String> role = userRolesRepository.findRoleByUserName(username);
		if(role.get(0).equalsIgnoreCase("ROLE_ADMIN")){
			model.setViewName("redirect:/admin/registration");
		}
		else if(role.get(0).equalsIgnoreCase("ROLE_USER")){
			try{
				CandidateRegistrationDTO candidateRegistrationDTO = candidateRegistrationService.findByUserName(username);
				if(candidateRegistrationDTO.getIsEnabled()){
					model.setViewName("redirect:/user/instruction?candidateId="+candidateRegistrationDTO.getId());
				}else{
					model.setViewName("redirect:/403");
				}
			}catch(Exception pe){
				LOGGER.error("This user has been deleted");
				throw new ProgramException("This user has been deleted.",pe);
			}
		}else if(role.get(0).equalsIgnoreCase("ROLE_OTHER")){
			if(username.equalsIgnoreCase("admin123")){
				model.setViewName("redirect:/testSet");
			}
		}
		return model;
	}
	
	@RequestMapping(value = "/testSet", method = RequestMethod.GET)
	public String testSetForOther(HttpServletRequest request,Locale locale,Model model, HttpServletResponse response)throws ProgramException{
		List<TestSetDTO> testSetDTOList = testSetService.findAllByIsEnable();
		model.addAttribute("testSetList", testSetDTOList);
		return "testSetForOther";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout,Model uiModel) {

		ModelAndView model = new ModelAndView();
		if (error != null) {
			model.addObject("error", "Invalid username and password!");
		}

		if (logout != null) {
			model.addObject("msg", "You've been logged out successfully.");
		}
		UpdateNotificationDTO updateNotificationDTO = updateNotificationService.findLatestNotification();
		uiModel.addAttribute("updateNotification", updateNotificationDTO);
		return "index";

	}
	
	//for 403 access denied page
	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public ModelAndView accesssDenied() {
		ModelAndView model = new ModelAndView();
		//check if user is login
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			UserDetails userDetail = (UserDetails) auth.getPrincipal();
			System.out.println(userDetail);
			model.addObject("username", userDetail.getUsername());
		}
		model.setViewName("403");
		return model;
	}
	
	@RequestMapping(value = "/forgetPassword", method = RequestMethod.GET)
	public String forgetPass(HttpServletRequest request,Model model){
		request.setAttribute("mode", "MODE_VALIDEMAIL");
		return "forgetPassword";
	}
	
	@RequestMapping(value = "/checkEmail", method = RequestMethod.POST)
	public String comfirmMail(@RequestParam String email,HttpServletRequest request,Model model) throws ProgramException{
		UserDTO userDTO =userService.findByEmail(email);
		if(userDTO != null){
			model.addAttribute("user", userDTO);
			request.setAttribute("mode", "MODE_NEWPASSWORD");
		}else{
			model.addAttribute("message","Your e-mail is not valid !");
			request.setAttribute("mode", "MODE_VALIDEMAIL");
		}
		return "forgetPassword";
	}
	
	@RequestMapping(value = "/changePassword", method = RequestMethod.POST)
	public String changePass(@RequestParam String email,@RequestParam String newPassword, HttpServletRequest request,
			Model model,Locale locale){
		UserDTO userDTO = userService.getByEmailAndPass(email,newPassword);
		request.setAttribute("mode", "MODE_NEWPASSWORD");
		model.addAttribute("message","Your Password is successfully Updated");
		return "forgetPassword";
	}
	
//	@RequestMapping(value = "/sendingEmail")
//	@ResponseBody
//	public String sendEmail(){
//		final String from = "srivastava.praveen9@gmail.com";
//		final String pass = "";
//		UserDTO user = new UserDTO();
//		user.setName("Praveen Srivastava");
//		user.setEmail("shishu.praveen65@gmail.com");
//		try{
//			notificationService.sendNotification(user);
//		}catch (MailException e) {
//			LOGGER.info("Error Sending Email : " +e.getMessage());
//		}
//		emailService.send(from,pass,"shishu.praveen65@gmail.com","sending mail","hi praveen");
//		return "Thank you for registering with us";
//		
//	}
	
	@RequestMapping(value = "/contactUs", method = RequestMethod.POST)
	public String contactUs(@ModelAttribute ContactUsDTO contactUsDTO, BindingResult bindingResult,HttpServletRequest request,
			Locale locale,Model model){
		contactUsDTO = contactService.create(contactUsDTO);
		return "redirect:/login";
	}
}
