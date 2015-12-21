package com.chevyshirts.dto;

import com.chevyshirts.model.User;

/**
 * 
 * @author Mark Martinez, created Dec 10, 2015
 *
 */
public class CreateUserRequest {

    private User user;
    private boolean resetPassword;

    public boolean isResetPassword() {
        return resetPassword;
    }
    public void setResetPassword(boolean resetPassword) {
        this.resetPassword = resetPassword;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }

}
