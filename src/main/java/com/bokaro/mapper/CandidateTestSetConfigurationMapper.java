package com.bokaro.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.bokaro.dto.CandidateTestSetConfigurationDTO;
import com.bokaro.entity.CandidateTestSetConfiguration;

@Mapper(componentModel = "spring", uses = {})
public interface CandidateTestSetConfigurationMapper {

	CandidateTestSetConfigurationDTO candidateTestSetConfigurationToCandidateTestSetConfigurationtDTO(CandidateTestSetConfiguration candidateTestSetConfiguration);
	CandidateTestSetConfiguration candidateTestSetConfigurationDTOToCandidateTestSetConfiguration(CandidateTestSetConfigurationDTO candidateTestSetConfigurationDTO);
	List<CandidateTestSetConfiguration> candidateTestSetConfigurationDTOListToCandidateTestSetConfigurationList(List<CandidateTestSetConfigurationDTO> candidateTestSetConfigurationDTOList);
	List<CandidateTestSetConfigurationDTO> candidateTestSetConfigurationListToCandidateTestSetConfigurationDTOList(List<CandidateTestSetConfiguration> candidateTestSetConfigurationList);
	
}
