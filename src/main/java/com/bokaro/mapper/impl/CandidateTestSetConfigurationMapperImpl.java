package com.bokaro.mapper.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

import org.springframework.stereotype.Component;

import com.bokaro.dto.CandidateTestSetConfigurationDTO;
import com.bokaro.entity.CandidateTestSetConfiguration;
import com.bokaro.mapper.CandidateTestSetConfigurationMapper;

@Generated(
	    value = "org.mapstruct.ap.MappingProcessor",
	    comments = "version: 1.0.0.Final, compiler: javac, environment: Java 1.8.0_101 (Oracle Corporation)"
	)
	@Component
public class CandidateTestSetConfigurationMapperImpl implements CandidateTestSetConfigurationMapper {

	@Override
	public CandidateTestSetConfigurationDTO candidateTestSetConfigurationToCandidateTestSetConfigurationtDTO(
			CandidateTestSetConfiguration candidateTestSetConfiguration) {
		if(candidateTestSetConfiguration == null){
			return null;
		}
		CandidateTestSetConfigurationDTO candidateTestSetConfigurationDTO = new CandidateTestSetConfigurationDTO();
		candidateTestSetConfigurationDTO.setId(candidateTestSetConfiguration.getId());
		candidateTestSetConfigurationDTO.setCandidateId(candidateTestSetConfiguration.getCandidateId());
		candidateTestSetConfigurationDTO.setTestSetId(candidateTestSetConfiguration.getTestSetId());
		candidateTestSetConfigurationDTO.setStatus(candidateTestSetConfiguration.getStatus());
		candidateTestSetConfigurationDTO.setCreateDate(candidateTestSetConfiguration.getCreateDate());
		return candidateTestSetConfigurationDTO;
	}

	@Override
	public CandidateTestSetConfiguration candidateTestSetConfigurationDTOToCandidateTestSetConfiguration(
			CandidateTestSetConfigurationDTO candidateTestSetConfigurationDTO) {
		if(candidateTestSetConfigurationDTO == null){
			return null;
		}
		CandidateTestSetConfiguration candidateTestSetConfiguration = new CandidateTestSetConfiguration();
		candidateTestSetConfiguration.setId(candidateTestSetConfigurationDTO.getId());
		candidateTestSetConfiguration.setCandidateId(candidateTestSetConfigurationDTO.getCandidateId());
		candidateTestSetConfiguration.setTestSetId(candidateTestSetConfigurationDTO.getTestSetId());
		candidateTestSetConfiguration.setStatus(candidateTestSetConfigurationDTO.getStatus());
		candidateTestSetConfiguration.setCreateDate(candidateTestSetConfigurationDTO.getCreateDate());
		return candidateTestSetConfiguration;
	}

	@Override
	public List<CandidateTestSetConfiguration> candidateTestSetConfigurationDTOListToCandidateTestSetConfigurationList(
			List<CandidateTestSetConfigurationDTO> candidateTestSetConfigurationDTOList) {
		if(candidateTestSetConfigurationDTOList ==null){
			return null;
		}
		List<CandidateTestSetConfiguration> candidateTestSetConfigurationList = new ArrayList<>();
		for(CandidateTestSetConfigurationDTO candidateTestSetConfigurationDTO : candidateTestSetConfigurationDTOList){
			candidateTestSetConfigurationList.add(candidateTestSetConfigurationDTOToCandidateTestSetConfiguration(candidateTestSetConfigurationDTO));
		}
		return candidateTestSetConfigurationList;
	}

	@Override
	public List<CandidateTestSetConfigurationDTO> candidateTestSetConfigurationListToCandidateTestSetConfigurationDTOList(
			List<CandidateTestSetConfiguration> candidateTestSetConfigurationList) {
		if(candidateTestSetConfigurationList ==null){
			return null;
		}
		List<CandidateTestSetConfigurationDTO> candidateTestSetConfigurationDTOList = new ArrayList<>();
		for(CandidateTestSetConfiguration candidateTestSetConfiguration : candidateTestSetConfigurationList){
			candidateTestSetConfigurationDTOList.add(candidateTestSetConfigurationToCandidateTestSetConfigurationtDTO(candidateTestSetConfiguration));
		}
		return candidateTestSetConfigurationDTOList;
	}

}
