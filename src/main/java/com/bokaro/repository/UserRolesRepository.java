package com.bokaro.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bokaro.entity.UserRole;

@Repository
public interface UserRolesRepository extends JpaRepository<UserRole, Long> {

	@Query(value="select a.role from user_roles a, users b where a.userid=b.userid and b.username=?1",nativeQuery=true)
    List<String> findRoleByUserName(String username);

	@Query(value="select a.role from user_roles a, users b where a.userid=b.userid and b.username=?1",nativeQuery=true)
	String findUserRoleByUserName(String username);
	
}
