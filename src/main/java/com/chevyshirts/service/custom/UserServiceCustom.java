package com.chevyshirts.service.custom;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.chevyshirts.dto.CreateUserRequest;
import com.chevyshirts.model.User;

/**
 * 
 * @author Mark Martinez, created Nov 29, 2015
 *
 */
public interface UserServiceCustom extends UserDetailsService {

    User updateUser(CreateUserRequest updateUserRequest);

}
