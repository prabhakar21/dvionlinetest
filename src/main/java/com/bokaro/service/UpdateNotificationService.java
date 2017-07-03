package com.bokaro.service;

import java.util.List;

import com.bokaro.dto.UpdateNotificationDTO;

public interface UpdateNotificationService {

	List<UpdateNotificationDTO> findAllOrderByIdDesc();

	UpdateNotificationDTO create(String message);

	UpdateNotificationDTO findLatestNotification();

	void delete(Long id);

}
