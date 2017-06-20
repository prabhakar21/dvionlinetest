package com.bokaro.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.bokaro.dto.UpdateNotificationDTO;
import com.bokaro.entity.UpdateNotification;

@Mapper(componentModel = "spring", uses = {})
public interface UpdateNotificationMapper {

	UpdateNotificationDTO updateNotificationToUpdateNotificationDTO(UpdateNotification updateNotification);
	UpdateNotification updateNotificationDTOToUpdateNotification(UpdateNotificationDTO updateNotificationDTO);
	List<UpdateNotification> updateNotificationDTOListToUpdateNotificationList(List<UpdateNotificationDTO> updateNotificationDTOList);
	List<UpdateNotificationDTO> updateNotificationListToUpdateNotificationDTOList(List<UpdateNotification> updateNotificationList);
}
