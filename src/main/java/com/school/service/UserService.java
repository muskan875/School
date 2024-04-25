package com.school.service;

import com.school.dto.UserDto;

public interface UserService {

	 UserDto registration(UserDto userDto) ;
	    public int getUserId(String email) ;
	    boolean isEmailExists(String email);
}
