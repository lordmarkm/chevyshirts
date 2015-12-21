package com.chevyshirts.service.custom.impl;

import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import com.chevyshirts.dto.CreateUserRequest;
import com.chevyshirts.model.User;
import com.chevyshirts.service.UserService;
import com.chevyshirts.service.custom.UserServiceCustom;
import com.google.common.collect.Lists;

/**
 * 
 * @author Mark Martinez, created Nov 29, 2015
 *
 */
@Transactional
public class UserServiceCustomImpl implements UserServiceCustom {

    private static final Logger LOG = LoggerFactory.getLogger(UserServiceCustomImpl.class);

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserService repo;

    @PostConstruct
    public void createDefaultAdmin() {
        if (repo.count() == 0) {
            User user = new User();
            user.setCreatedBy("SYSTEM");
            user.setDescription("Default user");
            user.setName("markm");
            user.setPassword(passwordEncoder.encode("123qwe"));
            user.setRole("ROLE_ADMIN");
            user.setUpdatedBy("SYSTEM");
            repo.save(user);
        }
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        LOG.info("Authenticating user. username={}", username);

        User user = repo.findByName(username);
        if (null == user) {
            throw new UsernameNotFoundException("User " + username + " not found.");
        }

        List<SimpleGrantedAuthority> authorities = Lists.newArrayList();
        authorities.add(new SimpleGrantedAuthority(user.getRole()));

        UserDetails userDetails = new org.springframework.security.core.userdetails.User(user.getName(), user.getPassword(), authorities);

        return userDetails;
    }

    @Override
    public User updateUser(CreateUserRequest createUserRequest) {
        //Save the user
        User user = createUserRequest.getUser();
        if (StringUtils.isEmpty(user.getCode())) {
            //New user (create operation)
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user = repo.save(createUserRequest.getUser());

            //Give user a code
            if (StringUtils.isEmpty(user.getCode())) {
                User existing;
                String candidateCode;
                do {
                    candidateCode = RandomStringUtils.randomAlphanumeric(5).toLowerCase();
                    existing = repo.findByCode(candidateCode);
                } while (null != existing);
                user.setCode(candidateCode);
            }
        } else {
            //Existing user (update operation)
            user = repo.findByCode(user.getCode());
            user.setName(user.getName());
            user.setRole(user.getRole());
            if (createUserRequest.isResetPassword()) {
                user.setPassword(passwordEncoder.encode(user.getPassword()));
            }
        }

        return user;
    }

}
