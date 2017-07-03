package com.bokaro.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bokaro.dto.CandidateRegistrationDTO;
import com.bokaro.dto.ContactUsDTO;
import com.bokaro.dto.ResultDTO;
import com.bokaro.exception.ProgramException;
import com.bokaro.service.CandidateRegistrationService;
import com.bokaro.service.ContactUsService;
import com.bokaro.service.ResultService;
import com.bokaro.service.UserService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Value("${imageFolder}")
	private String imagePath;
	
	@Autowired
	private CandidateRegistrationService candidateRegistrationService;
	@Autowired
	private UserService userService;
	@Autowired
	private ContactUsService contactService;

	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public String registrationPage(HttpServletRequest request){
		request.setAttribute("mode", "MODE_REGISTRATION");
		return "home";
	}

	@RequestMapping(value = "/questionPage", method = RequestMethod.GET)
	public String questionPage(HttpServletRequest request){
		request.setAttribute("mode", "MODE_QUESTIONFORM");
		return "testPage";
	}
	
	@RequestMapping(value = "/questionForm", method = RequestMethod.GET)
	public String questionForm(HttpServletRequest request){
		request.setAttribute("mode", "MODE_QUESTIONFORM");
		return "questionForm";
	}
	
	@RequestMapping(value = "/questionSubmit", method = RequestMethod.POST)
	public String questionCreate(@RequestParam  HttpServletRequest request){
		return "questionForm";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String candidateRegistration(HttpServletRequest request){
		request.setAttribute("mode", "MODE_QUESTIONFORM");
		return "testPage";
	}
	
	@RequestMapping(value = "/backupImages", method = RequestMethod.GET)
	public String backupImages(HttpServletRequest request){
		File folder = new File(System.getProperty("user.home")+File.separator+this.imagePath);//destination path
		String fileNameWithOutExt = null;
		if(!folder.exists()){
			folder.mkdir();
		}
		File[] listOfFiles = folder.listFiles();
			for (File sourceFile : listOfFiles) {
				fileNameWithOutExt = FilenameUtils.removeExtension(sourceFile.getName());
				String targetFolder = request.getRealPath("/")+"images"+File.separator+"questionImages";
				File targetFolderGenerated = new File(targetFolder);
				if(!targetFolderGenerated.exists())
					targetFolderGenerated.mkdirs();
				File destFile = new File(targetFolder+File.separator+fileNameWithOutExt+".jpg");
				if (!sourceFile.exists()) {
					System.out.println("Source File Not Found!");
				}
				if (!destFile.exists()) {
					try {
						destFile.createNewFile();
						System.out.println("Destination file doesn't exist. Creating one!");
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				FileChannel source = null;
				FileChannel destination = null;
				try {
					source = new FileInputStream(sourceFile).getChannel();
					destination = new FileOutputStream(destFile).getChannel();
					if (destination != null && source != null) {
						destination.transferFrom(source, 0, source.size());
					}
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				finally {
					if (source != null) {
						try {
							source.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
					if (destination != null) {
						try {
							destination.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			}
		return "redirect:/admin/questionPaper";
	}
	
//	@RequestMapping(value = "/testResult", method = RequestMethod.GET)
//	public String candidateTestResult(HttpServletRequest request,Model model){
//		List<ResultDTO> resultList = resultService.findAll();
//		for(ResultDTO resultDTO : resultList){
//			CandidateRegistrationDTO candidateRegistrationDTO = candidateRegistrationService.findById(resultDTO.getCandidateId());
//			if(candidateRegistrationDTO ==null)
//				continue;
//			resultDTO.setCandidateName(candidateRegistrationDTO.getFullname());
//			resultDTO.setEmail(candidateRegistrationDTO.getEmail());
//		}
//		model.addAttribute("resultList", resultList);
//		return "candidateTestResult";
//	}
	
	@RequestMapping(value = "/changePassword", method = RequestMethod.GET)
	public String newPass(HttpServletRequest request,Model model,Locale locale) throws ProgramException{
		
		return "changePasswordForAdmin";
	}
	
	@RequestMapping(value = "/create/newPassword", method = RequestMethod.POST)
	public String changePass(@RequestParam String newPassword, HttpServletRequest request,
			Model model,Locale locale){
		userService.changePassword(newPassword);
		return "redirect:/admin/registration";
	}
	
	@RequestMapping(value = "/contactUs", method = RequestMethod.GET)
	public String showContactUs(HttpServletRequest request,Locale locale,Model model) throws ProgramException{
		List<ContactUsDTO> contactUsDTOs = contactService.findAll();
		model.addAttribute("contactUs", contactUsDTOs);
		return "contactUs";
	}
	
	@RequestMapping(value = "/deleteContactUs", method = RequestMethod.GET)
	public String deleteContactUs(@RequestParam("id") Long id,HttpServletRequest request,Locale locale,Model model) throws ProgramException{
		contactService.delete(id);
		return "redirect:/admin/contactUs";
	}
}
