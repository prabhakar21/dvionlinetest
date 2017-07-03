package com.bokaro.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.bokaro.dto.CandidateRegistrationDTO;
import com.bokaro.entity.CandidateRegistration;

@Mapper(componentModel = "spring", uses = {})
public interface CandidateRegistrationMapper {
	
	CandidateRegistrationDTO candidateRegistrationToCandidateRegistrationDTO(CandidateRegistration candidateRegistration);
	CandidateRegistration candidateRegistrationDTOToCandidateRegistration(CandidateRegistrationDTO candidateRegistrationDTO);
	List<CandidateRegistration> candidateRegistrationDTOListToCandidateRegistrationList(List<CandidateRegistrationDTO> candidateRegistrationDTOList);
	List<CandidateRegistrationDTO> candidateRegistrationListToCandidateRegistrationDTOList(List<CandidateRegistration> candidateRegistrationList);

}
