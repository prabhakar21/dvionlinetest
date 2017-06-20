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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bokaro.dto.CandidateRegistrationDTO;
import com.bokaro.dto.ContactUsDTO;
import com.bokaro.exception.ProgramException;
import com.bokaro.service.CandidateRegistrationService;
import com.bokaro.service.ContactService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Value("${imageFolder}")
	private String imagePath;
	
	@Autowired
	private CandidateRegistrationService candidateRegistrationService;
	@Autowired
	private ContactService contactService;

	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public String registrationPage(HttpServletRequest request) throws ProgramException{
		request.setAttribute("mode", "MODE_REGISTRATION");
		return "home";
	}

	@RequestMapping(value = "/backupImages", method = RequestMethod.GET)
	public String backupImages(HttpServletRequest request) throws ProgramException{
		File folder = new File(System.getProperty("user.home")+this.imagePath);//destination path
		String fileNameWithOutExt = null;
		if(folder.exists()){
		File[] listOfFiles = folder.listFiles();
			for (File sourceFile : listOfFiles) {
				fileNameWithOutExt = FilenameUtils.removeExtension(sourceFile.getName());
				File destFile = new File(request.getRealPath("/")+File.separator+"images"+File.separator+fileNameWithOutExt+".jpg");
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
		}
		return "redirect:/admin/questionPaper";
	}
	
	@RequestMapping(value = "/searchCandidate", method = RequestMethod.POST)
	public String searchCandidate(@RequestParam("name") String name,@RequestParam("email") String email,
			@RequestParam("mobileNumber") String mobileNumber,@RequestParam("date") String date,HttpServletRequest request,
			RedirectAttributes redirectAttributes,Locale locale,Model model) throws ProgramException{
		List<CandidateRegistrationDTO> candidateRegistrationDTOs = candidateRegistrationService.getCandidateDetails(name,email,mobileNumber,date);
		if(candidateRegistrationDTOs.isEmpty()){
			model.addAttribute("message", "No any records found.");
		}
		request.setAttribute("mode", "MODE_CADIDATELIST");
		model.addAttribute("candidateList", candidateRegistrationDTOs);
		return "home";
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
