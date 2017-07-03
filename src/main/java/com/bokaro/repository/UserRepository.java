package com.bokaro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bokaro.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

//	@Query(value="select a.* from users a where a.username=?1",nativeQuery=true)
	User findByUserName(String username);

	User findByEmail(String email);

	@Query("SELECT u FROM User u,CandidateRegistration c,TestPackage tp where tp.candidateId=c.id and c.email=u.email and tp.candidateId=?1")
	User findByCandidateId(Long candidateId);

}
