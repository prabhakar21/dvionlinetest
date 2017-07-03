package com.bokaro.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bokaro.dto.CandidateTestSetConfigurationDTO;
import com.bokaro.entity.CandidateRegistration;
import com.bokaro.entity.CandidateTestSetConfiguration;
import com.bokaro.mapper.CandidateTestSetConfigurationMapper;
import com.bokaro.repository.CandidateRegistrationRepository;
import com.bokaro.repository.CandidateTestSetConfigurationRepository;
import com.bokaro.service.CandidateTestSetConfigurationService;

@Service
@Transactional
public class CandidateTestSetConfigurationServiceImpl implements CandidateTestSetConfigurationService {

	@Autowired
	private CandidateTestSetConfigurationRepository candidateTestSetConfigurationRepository;
	@Autowired
	private CandidateTestSetConfigurationMapper candidateTestSetConfigurationMapper;
	@Autowired
	private CandidateRegistrationRepository candidateRegistrationRepository;
	
	@Override
	public List<CandidateTestSetConfigurationDTO> getDataByCandidateId(Long testSetId, String email) {
		List<CandidateTestSetConfigurationDTO> candidateTestSetConfigurationDTOList = new ArrayList<CandidateTestSetConfigurationDTO>();
		String[] emailArray = email.split(",");
		for (String emailFromArray : emailArray) {
			CandidateTestSetConfiguration candidateTestSetConfiguration = new CandidateTestSetConfiguration();
			candidateTestSetConfiguration.setTestSetId(testSetId);
			CandidateRegistration candidateRegistration = candidateRegistrationRepository.findByEmail(emailFromArray);
			candidateTestSetConfiguration.setCandidateId(candidateRegistration.getId());
			candidateTestSetConfiguration.setCreateDate(new Date());
			candidateTestSetConfiguration = candidateTestSetConfigurationRepository.saveAndFlush(candidateTestSetConfiguration);
			candidateTestSetConfigurationDTOList.add(candidateTestSetConfigurationMapper.candidateTestSetConfigurationToCandidateTestSetConfigurationtDTO(candidateTestSetConfiguration));
		}
		return candidateTestSetConfigurationDTOList;
	}

	@Override
	public void delete(Long candidateTestSetConfigurationId) {
		candidateTestSetConfigurationRepository.delete(candidateTestSetConfigurationId);
	}


}
