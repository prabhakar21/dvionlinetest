package com.bokaro.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.bokaro.dto.ContactUsDTO;
import com.bokaro.entity.ContactUs;

@Mapper(componentModel = "spring", uses = {})
public interface ContactUsMapper {

	ContactUsDTO contactUsToContactUsDTO(ContactUs contactUs);
	ContactUs contactUsDTOToContactUs(ContactUsDTO contactUsDTO);
	List<ContactUs> contactUsDTOListToContactUsList(List<ContactUsDTO> contactUsDTOList);
	List<ContactUsDTO> contactUsListToContactUsDTOList(List<ContactUs> contactUsList);
	
}
