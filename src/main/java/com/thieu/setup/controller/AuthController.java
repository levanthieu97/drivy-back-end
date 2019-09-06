package com.thieu.setup.controller;

import com.thieu.setup.models.*;
import com.thieu.setup.security.JwtTokenProvider;
import com.thieu.setup.security.JwtUser;
import com.thieu.setup.services.UserRoleService;
import com.thieu.setup.services.UserService;
import com.thieu.tool.shared.ResponseObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping
public class    AuthController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthController.class);

    @Autowired
    private JwtTokenProvider jwtTokenProvider;


    @Autowired
    private UserService userService;

    private User validUser(String username, String password){
        User user = userService.loginUser(username);
        if(user != null && jwtTokenProvider.validatePassword(password, user.getPassword())){
            return user;
        }
        return null;
    }

    @PostMapping("/sign-in")
    public ResponseObject authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        ResponseObject responseObject = new ResponseObject<>();

        User user = validUser(loginRequest.getUsername(), loginRequest.getPassword());
        if (user != null){
            ResponseApi responseApi = new ResponseApi();
            responseApi.setAccount(user);
            responseApi.setToken(jwtTokenProvider.generateToken(JwtUser.create(user)));
            for(Role role : user.getRoles()){
                responseApi.setRole(role.getRoleName().name());
            }
            responseObject.setData(responseApi);
            responseObject.setSuccess(true);
        }else {
            responseObject.setSuccess(false);
            responseObject.setMessage("Tài khoản hoặc mật khẩu không đúng");
        }
        return responseObject;
    }

    @PostMapping("/register")
    public ResponseObject registerUser(@Valid @RequestBody RegisterRequest registerRequest){
        ResponseObject responseObject = new ResponseObject();
        try{
            if(userService.checkUser(registerRequest.getUsername()) != null){
                responseObject.setMessage("Tài khoản đã tồn tại !!!");
                responseObject.setSuccess(false);
            }else {
                User user = new User(registerRequest.getUsername(),
                        registerRequest.getPassword(), registerRequest.getFullname(), registerRequest.getEmail(),
                        registerRequest.getPhone(), registerRequest.getAddress()
                );
                user.setPassword(jwtTokenProvider.generatePassword(user.getPassword()));

                String strRoles = registerRequest.getRole();
                Set<Role> roles = new HashSet<>();

                switch (strRoles) {
                    case "user":
                        Role userRole = new Role(RoleName.ROLE_USER);
                        roles.add(userRole);
                        user.setRoleId(2);
                        break;
                    case "supplier":
                        Role supplierRole = new Role(RoleName.SUPPLIER);
                        roles.add(supplierRole);
                        user.setRoleId(3);
                        break;
                    case "admin":
                        Role adminRole = new Role(RoleName.ROLE_ADMIN);
                        roles.add(adminRole);
                        user.setRoleId(1);
                        break;
                    default:
                        break;
                }
                user.setRoles(roles);
                user.setIsEnable((byte) 1);
                user.setCreateDate(new Date());
                responseObject.setData(userService.registerUser(user));
                responseObject.setMessage("Đăng ký thành công !!!");
                responseObject.setSuccess(true);
            }
                return responseObject;

        }catch(Exception e){
            LOGGER.error("Error when call registerUser in UserController class: .", e);
            return ResponseObject.FAILURE;
        }
    }

}
