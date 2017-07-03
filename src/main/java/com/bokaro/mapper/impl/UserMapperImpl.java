package com.bokaro.mapper.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

import org.springframework.stereotype.Component;

import com.bokaro.dto.UserDTO;
import com.bokaro.entity.User;
import com.bokaro.mapper.UserMapper;

@Generated(
	    value = "org.mapstruct.ap.MappingProcessor",
	    comments = "version: 1.0.0.Final, compiler: javac, environment: Java 1.8.0_101 (Oracle Corporation)"
	)
	@Component
public class UserMapperImpl implements UserMapper {

	@Override
	public UserDTO userToUserDTO(User user) {
		if(user ==null){
			return null;
		}
		UserDTO userDTO = new UserDTO();
		userDTO.setUserId(user.getUserid());
		userDTO.setUserName(user.getUserName());
		userDTO.setEmail(user.getEmail());
		userDTO.setPassword(user.getPassword());
		userDTO.setName(user.getName());
		userDTO.setEnabled(user.getEnabled());
		return userDTO;
	}

	@Override
	public User userDTOToUser(UserDTO userDTO) {
		if(userDTO ==null){
			return null;
		}
		User user = new User();
		user.setUserid(userDTO.getUserId());
		user.setUserName(userDTO.getUserName());
		user.setEmail(userDTO.getEmail());
		user.setPassword(userDTO.getPassword());
		user.setEnabled(user.getEnabled());
		user.setName(userDTO.getName());
		return user;
	}

	@Override
	public List<User> userDTOListToUserList(List<UserDTO> userDTOList) {
		if(userDTOList ==null){
			return null;
		}
		List<User> userList = new ArrayList<>();
		for(UserDTO userDTO : userDTOList){
			userList.add(userDTOToUser(userDTO));
		}
		return userList;
	}

	@Override
	public List<UserDTO> userListToUserDTOList(List<User> userList) {
		if(userList ==null){
			return null;
		}
		List<UserDTO> userDTOList = new ArrayList<>();
		for(User user : userList){
			userDTOList.add(userToUserDTO(user));
		}
		return userDTOList;
	}

}
