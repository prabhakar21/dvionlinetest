package com.bokaro.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.bokaro.dto.UserRoleDTO;
import com.bokaro.entity.UserRole;

@Mapper(componentModel = "spring", uses = {})
public interface UserRoleMapper {

	UserRoleDTO userRoleToUserRoleDTO(UserRole userRole);
	UserRole userRoleDTOToUser(UserRoleDTO userRoleDTO);
	List<UserRole> userRoleDTOListToUserRoleList(List<UserRoleDTO> userRoleDTOList);
	List<UserRoleDTO> userRoleListToUserRoleDTOList(List<UserRole> userRoleList);
}
