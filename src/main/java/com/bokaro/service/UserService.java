package com.bokaro.service;

import com.bokaro.dto.UserDTO;

public interface UserService {

	UserDTO findByEmail(String email);

	UserDTO getByEmailAndPass(String email, String newPassword);

	void changePassword(String newPassword);

}
