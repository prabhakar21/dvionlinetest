package com.bokaro.mapper.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

import org.springframework.stereotype.Component;

import com.bokaro.dto.TestSetDTO;
import com.bokaro.entity.TestSet;
import com.bokaro.mapper.TestSetMapper;

@Generated(
	    value = "org.mapstruct.ap.MappingProcessor",
	    comments = "version: 1.0.0.Final, compiler: javac, environment: Java 1.8.0_101 (Oracle Corporation)"
	)
	@Component
public class TestSetMapperImpl implements TestSetMapper{

	@Override
	public TestSetDTO testSetToTestSetDTO(TestSet testSet) {
		if(testSet == null){
			return null;
		}
		TestSetDTO testSetDTO = new TestSetDTO();
		testSetDTO.setId(testSet.getId());
		testSetDTO.setQuestionSet(testSet.getQuestionSet());
		testSetDTO.setTimeInMin(testSet.getTimeInMin());
		testSetDTO.setCreateDate(testSet.getCreateDate());
		testSetDTO.setIsEnabled(testSet.getIsEnabled());
		return testSetDTO;
	}

	@Override
	public TestSet testSetDTOToTestSet(TestSetDTO testSetDTO) {
		if(testSetDTO == null){
			return null;
		}
		TestSet testSet = new TestSet();
		testSet.setId(testSetDTO.getId());
		testSet.setQuestionSet(testSetDTO.getQuestionSet());
		testSet.setTimeInMin(testSetDTO.getTimeInMin());
		testSet.setCreateDate(testSetDTO.getCreateDate());
		testSet.setIsEnabled(testSetDTO.getIsEnabled());
		return testSet;
	}

	@Override
	public List<TestSet> testSetDTOListToTestSetList(List<TestSetDTO> testSetDTOList) {
		if(testSetDTOList ==null){
			return null;
		}
		List<TestSet> testSetList = new ArrayList<>();
		for(TestSetDTO testSetDTO : testSetDTOList){
			testSetList.add(testSetDTOToTestSet(testSetDTO));
		}
		return testSetList;
	}

	@Override
	public List<TestSetDTO> testSetListToTestSetDTOList(List<TestSet> testSetList) {
		if(testSetList ==null){
			return null;
		}
		List<TestSetDTO> testSetDTOList = new ArrayList<>();
		for(TestSet testSet : testSetList){
			testSetDTOList.add(testSetToTestSetDTO(testSet));
		}
		return testSetDTOList;
	}

}
