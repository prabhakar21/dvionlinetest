package com.bokaro.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bokaro.dto.UpdateNotificationDTO;
import com.bokaro.entity.UpdateNotification;
import com.bokaro.mapper.UpdateNotificationMapper;
import com.bokaro.repository.UpdateNotificationRepository;
import com.bokaro.service.UpdateNotificationService;

@Service
@Transactional
public class UpdateNotificationServiceImpl implements UpdateNotificationService {

	@Autowired
	private UpdateNotificationRepository updateNotificationRepository;
	@Autowired
	private UpdateNotificationMapper updateNotificationMapper;
	
	@Override
	public List<UpdateNotificationDTO> findAllOrderByIdDesc() {
		List<UpdateNotification> updateNotificationList = updateNotificationRepository.findAllOrderByIdDesc();
		return updateNotificationMapper.updateNotificationListToUpdateNotificationDTOList(updateNotificationList);
	}

	@Override
	public UpdateNotificationDTO create(String message) {
		UpdateNotificationDTO updateNotificationDTO = new UpdateNotificationDTO();
		updateNotificationDTO.setMessage(message);
		UpdateNotification updateNotification = updateNotificationMapper.updateNotificationDTOToUpdateNotification(updateNotificationDTO);
		updateNotification =  updateNotificationRepository.saveAndFlush(updateNotification);
		return updateNotificationMapper.updateNotificationToUpdateNotificationDTO(updateNotification);
	}

	@Override
	public UpdateNotificationDTO findLatestNotification() {
		UpdateNotification updateNotification = updateNotificationRepository.findLatestNotification();
		return updateNotificationMapper.updateNotificationToUpdateNotificationDTO(updateNotification);
	}

	@Override
	public void delete(Long id) {
		updateNotificationRepository.delete(id);
	}

}
