package com.bokaro.service.impl;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bokaro.dto.ContactUsDTO;
import com.bokaro.entity.ContactUs;
import com.bokaro.mapper.ContactUsMapper;
import com.bokaro.repository.ContactUsRepository;
import com.bokaro.service.ContactService;

@Service
@Transactional
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactUsRepository contactUsRepository;
	@Autowired
	private ContactUsMapper contactUsMapper;
	
	@Override
	public ContactUsDTO create(ContactUsDTO contactUsDTO) {
		contactUsDTO.setCreateDate(new Date());
		ContactUs contactUs = contactUsMapper.contactUsDTOToContactUs(contactUsDTO);
		contactUs = contactUsRepository.saveAndFlush(contactUs);
		return contactUsMapper.contactUsToContactUsDTO(contactUs);
	}

	@Override
	public List<ContactUsDTO> findAll() {
		List<ContactUs> contactUs = contactUsRepository.findAllOrderById();
		return contactUsMapper.contactUsListToContactUsDTOList(contactUs);
	}

	@Override
	public void delete(Long id) {
		contactUsRepository.delete(id);
	}

	
}
