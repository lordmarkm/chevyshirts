package com.chevyshirts.model;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * 
 * @author Mark Martinez, created Nov 29, 2015
 *
 */
@Entity(name = "user")
@AttributeOverride(name = "name", column = @Column(name = "name", nullable = false, unique = true))
public class User extends BaseNamedEntity {

    @Column(name = "pw", nullable = false)
    private String password;

    @Column(name = "role", nullable = false)
    private String role;

    @Column(name = "user_code", unique = true)
    private String code;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }


}
