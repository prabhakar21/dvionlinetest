package com.bokaro.service;

import java.util.List;

import com.bokaro.dto.CandidateTestSetConfigurationDTO;

public interface CandidateTestSetConfigurationService {

	List<CandidateTestSetConfigurationDTO> getDataByCandidateId(Long testSetId, String email);

	void delete(Long candidateTestSetConfigurationId);

}
