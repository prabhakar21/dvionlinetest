package com.bokaro.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.bokaro.entity.CandidateRegistration;

public interface CandidateRegistrationRepository extends JpaRepository<CandidateRegistration, Long> {

	@Query("select c from CandidateRegistration c,User u where c.email=u.email and u.userName=?1")
	CandidateRegistration findByUsername(String username);
	
	@Query("select c.id from CandidateRegistration c ,User u where c.email=u.email and u.userName=?1")
	Long findId(String username);

	List<CandidateRegistration> findByIsEnabled(boolean b);

	CandidateRegistration findByEmail(String email);

	@Query("select c from CandidateRegistration c order by c.id desc")
	List<CandidateRegistration> findAllOrderById();

	@Query("select c from CandidateRegistration c, CandidateTestSetConfiguration cts,TestSet tt where cts.candidateId=c.id and cts.testSetId=tt.id and tt.id=?1")
	List<CandidateRegistration> findByTestSetId(Long testSetId);

}
