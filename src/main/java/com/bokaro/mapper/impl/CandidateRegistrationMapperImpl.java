package com.bokaro.mapper.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

import org.springframework.stereotype.Component;

import com.bokaro.dto.CandidateRegistrationDTO;
import com.bokaro.entity.CandidateRegistration;
import com.bokaro.mapper.CandidateRegistrationMapper;

@Generated(
	    value = "org.mapstruct.ap.MappingProcessor",
	    comments = "version: 1.0.0.Final, compiler: javac, environment: Java 1.8.0_101 (Oracle Corporation)"
	)
	@Component
public class CandidateRegistrationMapperImpl implements CandidateRegistrationMapper {

	@Override
	public CandidateRegistrationDTO candidateRegistrationToCandidateRegistrationDTO(
			CandidateRegistration candidateRegistration) {
		if(candidateRegistration ==null){
			return null;
		}
		CandidateRegistrationDTO candidateRegistrationDTO = new CandidateRegistrationDTO();
		candidateRegistrationDTO.setId(candidateRegistration.getId());
		candidateRegistrationDTO.setFullname(candidateRegistration.getFullname());
		candidateRegistrationDTO.setUsername(candidateRegistration.getUsername());
		candidateRegistrationDTO.setContactNumber(candidateRegistration.getContactNumber());
		candidateRegistrationDTO.setEmail(candidateRegistration.getEmail());
		candidateRegistrationDTO.setGender(candidateRegistration.getGender());
		candidateRegistrationDTO.setDateOfBirth(candidateRegistration.getDateOfBirth());
		candidateRegistrationDTO.setQualification(candidateRegistration.getQualification());
		candidateRegistrationDTO.setInstitute(candidateRegistration.getInstitute());
		candidateRegistrationDTO.setCity(candidateRegistration.getCity());
		candidateRegistrationDTO.setState(candidateRegistration.getState());
		candidateRegistrationDTO.setDateCreated(candidateRegistration.getDateCreated());
		candidateRegistrationDTO.setIsEnabled(candidateRegistration.getIsEnabled());
		candidateRegistrationDTO.setIsPackage(candidateRegistration.getIsPackage());
		return candidateRegistrationDTO;
	}

	@Override
	public CandidateRegistration candidateRegistrationDTOToCandidateRegistration(
			CandidateRegistrationDTO candidateRegistrationDTO) {
		if(candidateRegistrationDTO ==null){
			return null;
		}
		CandidateRegistration candidateRegistration = new CandidateRegistration();
		candidateRegistration.setId(candidateRegistrationDTO .getId());
		candidateRegistration.setFullname(candidateRegistrationDTO .getFullname());
		candidateRegistration.setUsername(candidateRegistrationDTO.getUsername());
		candidateRegistration.setContactNumber(candidateRegistrationDTO .getContactNumber());
		candidateRegistration.setEmail(candidateRegistrationDTO .getEmail());
		candidateRegistration.setGender(candidateRegistrationDTO .getGender());
		candidateRegistration.setDateOfBirth(candidateRegistrationDTO .getDateOfBirth());
		candidateRegistration.setQualification(candidateRegistrationDTO .getQualification());
		candidateRegistration.setInstitute(candidateRegistrationDTO .getInstitute());
		candidateRegistration.setCity(candidateRegistrationDTO .getCity());
		candidateRegistration.setState(candidateRegistrationDTO .getState());
		candidateRegistration.setDateCreated(candidateRegistrationDTO .getDateCreated());
		candidateRegistration.setIsEnabled(candidateRegistrationDTO.getIsEnabled());
		candidateRegistration.setIsPackage(candidateRegistrationDTO.getIsPackage());
		return candidateRegistration;
		
		
	}

	@Override
	public List<CandidateRegistration> candidateRegistrationDTOListToCandidateRegistrationList(
			List<CandidateRegistrationDTO> candidateRegistrationDTOList) {
		if(candidateRegistrationDTOList ==null){
			return null;
		}
		List<CandidateRegistration> candidateRegistrationList = new ArrayList<>();
		for(CandidateRegistrationDTO candidateRegistrationDTO : candidateRegistrationDTOList){
			candidateRegistrationList.add(candidateRegistrationDTOToCandidateRegistration(candidateRegistrationDTO));
		}
		return candidateRegistrationList;
	}

	@Override
	public List<CandidateRegistrationDTO> candidateRegistrationListToCandidateRegistrationDTOList(
			List<CandidateRegistration> candidateRegistrationList) {
		if(candidateRegistrationList ==null){
			return null;
		}
		List<CandidateRegistrationDTO> candidateRegistrationDTOList = new ArrayList<>();
		for(CandidateRegistration candidateRegistration : candidateRegistrationList){
			candidateRegistrationDTOList.add(candidateRegistrationToCandidateRegistrationDTO(candidateRegistration));
		}
		return candidateRegistrationDTOList;
	}

}
