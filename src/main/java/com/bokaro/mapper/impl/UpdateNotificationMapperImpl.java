package com.bokaro.mapper.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

import org.springframework.stereotype.Component;

import com.bokaro.dto.TestSetDTO;
import com.bokaro.dto.UpdateNotificationDTO;
import com.bokaro.entity.TestSet;
import com.bokaro.entity.UpdateNotification;
import com.bokaro.mapper.UpdateNotificationMapper;

@Generated(
	    value = "org.mapstruct.ap.MappingProcessor",
	    comments = "version: 1.0.0.Final, compiler: javac, environment: Java 1.8.0_101 (Oracle Corporation)"
	)
	@Component
public class UpdateNotificationMapperImpl implements UpdateNotificationMapper {

	@Override
	public UpdateNotificationDTO updateNotificationToUpdateNotificationDTO(UpdateNotification updateNotification) {
		if(updateNotification == null){
			return null;
		}
		UpdateNotificationDTO updateNotificationDTO = new UpdateNotificationDTO();
		updateNotificationDTO.setId(updateNotification.getId());
		updateNotificationDTO.setMessage(updateNotification.getMessage());
		return updateNotificationDTO;
	}

	@Override
	public UpdateNotification updateNotificationDTOToUpdateNotification(UpdateNotificationDTO updateNotificationDTO) {
		if(updateNotificationDTO == null){
			return null;
		}
		UpdateNotification updateNotification = new UpdateNotification();
		updateNotification.setId(updateNotificationDTO.getId());
		updateNotification.setMessage(updateNotificationDTO.getMessage());
		return updateNotification;
	}

	@Override
	public List<UpdateNotification> updateNotificationDTOListToUpdateNotificationList(
			List<UpdateNotificationDTO> updateNotificationDTOList) {
		if(updateNotificationDTOList ==null){
			return null;
		}
		List<UpdateNotification> updateNotificationList = new ArrayList<UpdateNotification>();
		for(UpdateNotificationDTO updateNotificationDTO : updateNotificationDTOList){
			updateNotificationList.add(updateNotificationDTOToUpdateNotification(updateNotificationDTO));
		}
		return updateNotificationList;
	}

	@Override
	public List<UpdateNotificationDTO> updateNotificationListToUpdateNotificationDTOList(
			List<UpdateNotification> updateNotificationList) {
		if(updateNotificationList ==null){
			return null;
		}
		List<UpdateNotificationDTO> updateNotificationDTOList = new ArrayList<UpdateNotificationDTO>();
		for(UpdateNotification updateNotification : updateNotificationList){
			updateNotificationDTOList.add(updateNotificationToUpdateNotificationDTO(updateNotification));
		}
		return updateNotificationDTOList;
	}

}
