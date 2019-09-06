package com.thieu.setup.services;

import com.thieu.setup.mappers.UserMapper;
import com.thieu.setup.models.User;
import com.thieu.setup.security.JwtUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userMapper.findByUserName(username);
        if(user == null){
            throw new UsernameNotFoundException(username);
        }

        return JwtUser.create(user);
    }
}
