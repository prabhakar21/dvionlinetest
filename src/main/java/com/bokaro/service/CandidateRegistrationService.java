package com.bokaro.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.bokaro.dto.CandidateRegistrationDTO;
import com.bokaro.exception.ProgramException;

public interface CandidateRegistrationService {

	CandidateRegistrationDTO create(CandidateRegistrationDTO candidateRegistrationDTO) throws ProgramException;

	List<CandidateRegistrationDTO> findAll();

	void delete(Long id);

	CandidateRegistrationDTO findById(Long id);

	CandidateRegistrationDTO update(CandidateRegistrationDTO candidateRegistrationDTO);

	CandidateRegistrationDTO findByUserName(String username);
	
	Long findId(String username);

	List<CandidateRegistrationDTO> getCandidateDetails(String name, String email, String mobileNumber, String date);

	List<CandidateRegistrationDTO> findByIsEnable(String enable);

	List<CandidateRegistrationDTO> findByTestSetId(Long testSetId);

	Page<CandidateRegistrationDTO> findAllPageable(Pageable pageable);

	CandidateRegistrationDTO getDisable(CandidateRegistrationDTO candidateRegistrationDTO);

}
