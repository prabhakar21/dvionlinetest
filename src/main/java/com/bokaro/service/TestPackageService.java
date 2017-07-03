package com.bokaro.service;

import java.util.List;

import com.bokaro.dto.TestPackageDTO;

public interface TestPackageService {

	TestPackageDTO create(TestPackageDTO testPackageDTO);

	List<TestPackageDTO> findActivePackage();

	List<TestPackageDTO> findExpirePackage();

	List<TestPackageDTO> findAssignPackage();

	TestPackageDTO findActivePackage(Long candidateId);

}
