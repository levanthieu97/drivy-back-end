package com.thieu.setup.services;

import com.thieu.setup.mappers.RoleMapper;
import com.thieu.setup.models.Role;
import com.thieu.tool.shared.CommonStrings;
import com.thieu.tool.shared.ResponseObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserRoleService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);


    @Autowired
    private RoleMapper roleMapper;

    public void getRoleForUser(int userID){
        try {
             roleMapper.getRoleForUser(userID,new Date());
        }catch (Exception e){
            LOGGER.error("Error when call registerUser in UserService class: .", e);

        }
    }

    public Role findRoleByName(String roleName){
        Role roles = new Role();
        try{
            roles= roleMapper.findRoleByName(roleName);
        }catch(Exception e){
            LOGGER.error("Fail when call loginUser.", e);
        }
        return roles;
    }

}
