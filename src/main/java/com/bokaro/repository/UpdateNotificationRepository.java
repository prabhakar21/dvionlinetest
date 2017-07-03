package com.bokaro.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bokaro.entity.UpdateNotification;

public interface UpdateNotificationRepository extends JpaRepository<UpdateNotification, Long>{

	@Query("select up from UpdateNotification up order by up.id desc")
	List<UpdateNotification> findAllOrderByIdDesc();

	@Query(value="select * from update_notification order by id desc limit 1",nativeQuery=true)
	UpdateNotification findLatestNotification();

}
