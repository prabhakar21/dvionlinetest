package com.bokaro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.bokaro.entity.CandidateTestSetConfiguration;

public interface CandidateTestSetConfigurationRepository extends JpaRepository<CandidateTestSetConfiguration, Long> {

	@Modifying
	@Query("delete from CandidateTestSetConfiguration where candidateId=?1")
	void deleteCandidateId(Long id);

	@Modifying
	@Query("delete from CandidateTestSetConfiguration where testSetId=?1")
	void deleteByTestSetId(Long testSetId);

}
