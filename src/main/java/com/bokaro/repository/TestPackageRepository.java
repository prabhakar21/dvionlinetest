package com.bokaro.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.bokaro.entity.TestPackage;

public interface TestPackageRepository extends JpaRepository<TestPackage, Long> {

	@Modifying
	@Query("delete from TestPackage where candidateId=?1")
	void deleteCandidateId(Long id);

	@Query(value="select * from test_packages tp where tp.candidate_id=?1 and ?2 between tp.start_date and tp.end_date",nativeQuery=true)
	TestPackage findByCadidateId(Long candidateId, Date date);
}
