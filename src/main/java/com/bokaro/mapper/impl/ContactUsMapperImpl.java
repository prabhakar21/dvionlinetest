package com.bokaro.mapper.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

import org.springframework.stereotype.Component;

import com.bokaro.dto.ContactUsDTO;
import com.bokaro.entity.ContactUs;
import com.bokaro.mapper.ContactUsMapper;

@Generated(
	    value = "org.mapstruct.ap.MappingProcessor",
	    comments = "version: 1.0.0.Final, compiler: javac, environment: Java 1.8.0_101 (Oracle Corporation)"
	)
	@Component
public class ContactUsMapperImpl implements ContactUsMapper {

	@Override
	public ContactUsDTO contactUsToContactUsDTO(ContactUs contactUs) {
		if(contactUs == null){
			return null;
		}
		ContactUsDTO contactUsDTO = new ContactUsDTO();
		contactUsDTO.setId(contactUs.getId());
		contactUsDTO.setName(contactUs.getName());
		contactUsDTO.setEmail(contactUs.getEmail());
		contactUsDTO.setComment(contactUs.getComment());
		contactUsDTO.setCreateDate(contactUs.getCreateDate());
		return contactUsDTO;
	}

	@Override
	public ContactUs contactUsDTOToContactUs(ContactUsDTO contactUsDTO) {
		if(contactUsDTO == null){
			return null;
		}
		ContactUs contactUs = new ContactUs();
		contactUs.setId(contactUsDTO.getId());
		contactUs.setName(contactUsDTO.getName());
		contactUs.setEmail(contactUsDTO.getEmail());
		contactUs.setComment(contactUsDTO.getComment());
		contactUs.setCreateDate(contactUsDTO.getCreateDate());
		return contactUs;
	}

	@Override
	public List<ContactUs> contactUsDTOListToContactUsList(List<ContactUsDTO> contactUsDTOList) {
		if(contactUsDTOList ==null){
			return null;
		}
		List<ContactUs> contactUsList = new ArrayList<ContactUs>();
		for(ContactUsDTO contactUsDTO : contactUsDTOList){
			contactUsList.add(contactUsDTOToContactUs(contactUsDTO));
		}
		return contactUsList;
	}

	@Override
	public List<ContactUsDTO> contactUsListToContactUsDTOList(List<ContactUs> contactUsList) {
		if(contactUsList ==null){
			return null;
		}
		List<ContactUsDTO> contactUsDTOList = new ArrayList<>();
		for(ContactUs contactUs : contactUsList){
			contactUsDTOList.add(contactUsToContactUsDTO(contactUs));
		}
		return contactUsDTOList;
	}

}
