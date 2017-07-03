package com.bokaro.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bokaro.entity.ContactUs;

public interface ContactUsRepository extends JpaRepository<ContactUs, Long> {

	@Query("select c from ContactUs c order by c.id desc")
	List<ContactUs> findAllOrderById();

}
