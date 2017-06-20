package com.bokaro.mapper.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

import org.springframework.stereotype.Component;

import com.bokaro.dto.UserRoleDTO;
import com.bokaro.entity.UserRole;
import com.bokaro.mapper.UserRoleMapper;

@Generated(
	    value = "org.mapstruct.ap.MappingProcessor",
	    comments = "version: 1.0.0.Final, compiler: javac, environment: Java 1.8.0_101 (Oracle Corporation)"
	)
	@Component
public class UserRoleMapperImpl implements UserRoleMapper {

	@Override
	public UserRoleDTO userRoleToUserRoleDTO(UserRole userRole) {
		 if ( userRole == null ) {
	            return null;
	        }
		 UserRoleDTO userRoleDTO = new UserRoleDTO();
		 userRoleDTO.setUserid(userRole.getUserid());
		 userRoleDTO.setRole(userRole.getRole());
		 userRoleDTO.setUserroleid(userRole.getUserroleid());
		 
		return userRoleDTO;
	}

	@Override
	public UserRole userRoleDTOToUser(UserRoleDTO userRoleDTO) {
		if(userRoleDTO == null){
			return null;
		}
		UserRole userRole = new UserRole();
		userRole.setUserid(userRoleDTO.getUserid());
		userRole.setRole(userRoleDTO.getRole());
		userRole.setUserroleid(userRoleDTO.getUserroleid());
		return userRole;
	}

	@Override
	public List<UserRole> userRoleDTOListToUserRoleList(List<UserRoleDTO> userRoleDTOList) {
		if(userRoleDTOList == null){
			return null;
		}
		List<UserRole> userRoles = new ArrayList<>();
		for(UserRoleDTO userRoleDTO : userRoleDTOList){
			userRoles.add(userRoleDTOToUser(userRoleDTO));
		}
		
		return userRoles;
	}

	@Override
	public List<UserRoleDTO> userRoleListToUserRoleDTOList(List<UserRole> userRoleList) {
		if(userRoleList == null){
			return null;
		}
		List<UserRoleDTO> userRoleDTOs = new ArrayList<>();
		for(UserRole userRole : userRoleList){
			userRoleDTOs.add(userRoleToUserRoleDTO(userRole));
		}
		return userRoleDTOs;
	}

}
