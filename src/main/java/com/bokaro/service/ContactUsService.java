package com.bokaro.service;

import java.util.List;

import com.bokaro.dto.ContactUsDTO;

public interface ContactUsService {

	ContactUsDTO create(ContactUsDTO contactUsDTO);

	List<ContactUsDTO> findAll();

	void delete(Long id);

}
