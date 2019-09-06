package com.thieu.setup.services;

import com.thieu.setup.mappers.UserMapper;
import com.thieu.setup.models.User;
import com.thieu.tool.mappers.OrdersMapper;
import com.thieu.tool.models.Orders;
import com.thieu.tool.shared.CommonStrings;
import com.thieu.tool.shared.ResponseObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private OrdersMapper ordersMapper;

    public User loginUser(String username){
        User user = new User();
        try{
            user= userMapper.findByUserName(username);
        }catch(Exception e){
            LOGGER.error("Fail when call loginUser.", e);
        }
        return user;
    }

    public User checkUser(String username){
        User user = userMapper.checkUser(username);
        if(user != null){
            return user;
        }
        return null;

    }


    public ResponseObject registerUser(User user){
        ResponseObject responseObject = new ResponseObject();
        try {
            int result = userMapper.registerForUser(user);

            Orders orders = new Orders();

            orders.setUserId(user.getUserId());
            orders.setIsActive(0);
            orders.setStatus("chưa thanh toán");
            orders.setQuantity(0);
            int ordersResult = ordersMapper.createShoppingCart(orders);

            if (result > 0) {
                responseObject.setSuccess(true);
                responseObject.setMessage(CommonStrings.RESP_MSG_SUCCESS);
            } else {
                responseObject.setSuccess(false);
                responseObject.setMessage(CommonStrings.RESP_MSG_SERVER_ERROR);
            }
        }catch (Exception e){
            LOGGER.error("Error when call registerUser in UserService class: .", e);
            return ResponseObject.FAILURE;

        }
        return responseObject;
    }

}
