package com.thieu.setup.controller;


import com.thieu.setup.models.User;
import com.thieu.setup.security.JwtTokenProvider;
import com.thieu.setup.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private UserService userService;


    private User validUser(String username, String password) {
        User user = userService.loginUser(username);
        if (user != null && jwtTokenProvider.validatePassword(password,user.getPassword())) {
            return user;
        }

        return null;
    }

}
