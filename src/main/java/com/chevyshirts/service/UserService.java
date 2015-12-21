package com.chevyshirts.service;

import com.chevyshirts.model.User;
import com.chevyshirts.service.custom.UserServiceCustom;

/**
 * 
 * @author Mark Martinez, created Nov 29, 2015
 *
 */
public interface UserService extends UserServiceCustom, TyraelJpaService<User> {

    User findByName(String username);
    User findByCode(String code);

}
