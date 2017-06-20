package com.bokaro.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.bokaro.entity.Result;

public interface ResultRepository extends JpaRepository<Result, Long> {

	@Query("select count(r) from Result r,TestPackage tp where tp.candidateId=r.candidateId and r.resultDate between tp.startDate and tp.endDate and tp.candidateId=?1")
	Long findByCandidateId(Long candidateId);

	@Query("select r from Result r order by r.id desc")
	List<Result> findAllOrderById();

	@Modifying
	@Query("delete from Result where candidateId=?1")
	void deleteCandidateId(Long id);

	@Query("select count(r) from Result r,CandidateRegistration c,TestPackage t where r.candidateId=c.id and t.candidateId=c.id  and r.resultDate between t.startDate and t.endDate and c.id=?1")
	Long countByCandidateId(Long candidateId);

}
