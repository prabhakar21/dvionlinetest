package com.bokaro.service;

import java.util.List;

import com.bokaro.dto.CandidateRegistrationDTO;

public interface CandidateRegistrationService {

	CandidateRegistrationDTO create(CandidateRegistrationDTO candidateRegistrationDTO);

	List<CandidateRegistrationDTO> findAll();

	void delete(Long id);

	CandidateRegistrationDTO findById(Long id);

	CandidateRegistrationDTO update(CandidateRegistrationDTO candidateRegistrationDTO);

	CandidateRegistrationDTO findByUserName(String username);
	
	Long findId(String username);

	List<CandidateRegistrationDTO> getCandidateDetails(String name, String email, String mobileNumber, String date);

	List<CandidateRegistrationDTO> findByIsEnable(String enable);
	
	List<CandidateRegistrationDTO> findByTestSetId(Long testSetId);

	CandidateRegistrationDTO getDisable(CandidateRegistrationDTO candidateRegistrationDTO);

}
