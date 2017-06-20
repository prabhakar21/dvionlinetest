package com.bokaro.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.bokaro.dto.UserDTO;
import com.bokaro.entity.User;

@Mapper(componentModel = "spring", uses = {})
public interface UserMapper {
	
	UserDTO userToUserDTO(User user);
	User userDTOToUser(UserDTO userDTO);
	List<User> userDTOListToUserList(List<UserDTO> userDTOList);
	List<UserDTO> userListToUserDTOList(List<User> userList);

}
