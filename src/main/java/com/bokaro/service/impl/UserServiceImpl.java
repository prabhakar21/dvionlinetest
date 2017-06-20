package com.bokaro.service.impl;

import javax.transaction.Transactional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.bokaro.dto.UserDTO;
import com.bokaro.entity.User;
import com.bokaro.mapper.UserMapper;
import com.bokaro.repository.UserRepository;
import com.bokaro.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private UserMapper userMapper;
	
	@Override
	public UserDTO findByEmail(String email) {
		User user = userRepository.findByEmail(email);
		return userMapper.userToUserDTO(user);
	}

	@Override
	public UserDTO getByEmailAndPass(String email, String newPassword) {
		User user = userRepository.findByEmail(email);
		String generatedSecuredPasswordHash = BCrypt.hashpw(newPassword, BCrypt.gensalt(12));
		user.setPassword(generatedSecuredPasswordHash);
		user = userRepository.saveAndFlush(user);
		return userMapper.userToUserDTO(user);
	}

	@Override
	public UserDTO changePassword(String newPassword) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetail = (UserDetails) auth.getPrincipal();
		User user = userRepository.findByUserName(userDetail.getUsername());
		String generatedSecuredPasswordHash = BCrypt.hashpw(newPassword, BCrypt.gensalt(12));
		user.setPassword(generatedSecuredPasswordHash);
		user = userRepository.saveAndFlush(user);
		return userMapper.userToUserDTO(user);
	}

}
