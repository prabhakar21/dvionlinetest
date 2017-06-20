package com.bokaro.service;

import java.util.List;

import com.bokaro.dto.TestSetDTO;

public interface TestSetService {

	List<TestSetDTO> findAll();

	TestSetDTO updateTime(Long id, Long timeInMin);

	void delete(Long id);

	TestSetDTO create(TestSetDTO testSetDTO);

	List<TestSetDTO> findByUsername(String username);

	TestSetDTO findById(Long testSetId);

	List<TestSetDTO> findAllByIsEnable();

	TestSetDTO update(TestSetDTO testSetDTO);

}
