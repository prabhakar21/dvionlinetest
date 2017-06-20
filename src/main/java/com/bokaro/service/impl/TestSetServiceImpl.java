package com.bokaro.service.impl;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bokaro.dto.TestSetDTO;
import com.bokaro.entity.TestSet;
import com.bokaro.mapper.TestSetMapper;
import com.bokaro.repository.CandidateTestSetConfigurationRepository;
import com.bokaro.repository.QuestionRepository;
import com.bokaro.repository.TestSetRepository;
import com.bokaro.service.TestSetService;

@Service
@Transactional
public class TestSetServiceImpl implements TestSetService{

	@Autowired
	private TestSetMapper testSetMapper;
	@Autowired
	private TestSetRepository testSetRepository;
	@Autowired
	private QuestionRepository questionRepository;
	@Autowired
	private CandidateTestSetConfigurationRepository candidateTestSetConfigurationRepository;
	
	@Override
	public TestSetDTO create(TestSetDTO testSetDTO) {
		TestSet testSet = testSetMapper.testSetDTOToTestSet(testSetDTO);
		testSet.setCreateDate(new Date());
		testSet = testSetRepository.saveAndFlush(testSet);
		return testSetMapper.testSetToTestSetDTO(testSet);
	}
	
	@Override
	public List<TestSetDTO> findAll() {
		List<TestSet> testSets = testSetRepository.findAll();
		return testSetMapper.testSetListToTestSetDTOList(testSets);
	}

	@Override
	public TestSetDTO updateTime(Long id, Long timeInMin) {
		TestSet testSet = testSetRepository.findOne(id);
		testSet.setTimeInMin(timeInMin);
		testSet = testSetRepository.saveAndFlush(testSet);
		return testSetMapper.testSetToTestSetDTO(testSet);
	}

	@Override
	public void delete(Long id) {
		testSetRepository.delete(id);
		questionRepository.deleteByQuestinSet(id.toString());
		candidateTestSetConfigurationRepository.deleteByTestSetId(id);
	}

	@Override
	public List<TestSetDTO> findByUsername(String username) {
		List<TestSet> testSets = testSetRepository.findTestSetOfUser(username);
		List<TestSetDTO> testSetDTOs = testSetMapper.testSetListToTestSetDTOList(testSets);
		for(TestSetDTO testSetDTO : testSetDTOs){
			Long noOfQuestion = questionRepository.findBySetId(testSetDTO.getId().toString());
			testSetDTO.setNoOfQuestion(noOfQuestion);
		}
		return testSetDTOs;
	}

	@Override
	public TestSetDTO findById(Long id) {
		TestSet testSet = testSetRepository.findOne(id);
		return testSetMapper.testSetToTestSetDTO(testSet);
	}

	@Override
	public List<TestSetDTO> findAllByIsEnable() {
		boolean isEnable = true;
		List<TestSet> testSets = testSetRepository.findAllByIsEnable(isEnable);
		List<TestSetDTO> testSetDTOs = testSetMapper.testSetListToTestSetDTOList(testSets);
		for(TestSetDTO testSetDTO : testSetDTOs){
			Long noOfQuestion = questionRepository.findBySetId(testSetDTO.getId().toString());
			testSetDTO.setNoOfQuestion(noOfQuestion);
		}
		return testSetDTOs;
	}

	@Override
	public TestSetDTO update(TestSetDTO testSetDTO) {
		TestSet testSet = testSetMapper.testSetDTOToTestSet(testSetDTO);
		testSet = testSetRepository.saveAndFlush(testSet);
		return testSetMapper.testSetToTestSetDTO(testSet);
	}

}
