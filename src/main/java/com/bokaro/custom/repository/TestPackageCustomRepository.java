package com.bokaro.custom.repository;

import java.util.Date;
import java.util.List;

import com.bokaro.entity.TestPackage;

public interface TestPackageCustomRepository {

	List<TestPackage> findByPackageStatus(Date date);

	List<TestPackage> findExpirePackage(Date date);

	List<TestPackage> findAssignPackage(Date date);

	TestPackage findByActivePackage(Date date, Long candidateId);

}
