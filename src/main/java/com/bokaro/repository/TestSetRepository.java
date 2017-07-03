package com.bokaro.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bokaro.entity.TestSet;

public interface TestSetRepository extends JpaRepository<TestSet, Long> {

	@Query(value="SELECT t FROM User u,CandidateRegistration c,TestSet t,CandidateTestSetConfiguration ct where c.id=ct.candidateId and ct.testSetId=t.id and u.email=c.email and u.userName=?1")
	List<TestSet> findTestSetOfUser(String username);

	@Query("SELECT ts FROM TestSet ts where isEnabled=?1")
	List<TestSet> findAllByIsEnable(boolean isEnable);

}
