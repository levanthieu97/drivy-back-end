package com.thieu.tool.services;

import com.thieu.tool.mappers.OrdersMapper;
import com.thieu.tool.models.Orders;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrdersService {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrdersService.class);

    @Autowired
    private OrdersMapper mapper;

    public int reNewOrder(int userId){
        Orders orders = new Orders();
        orders.setUserId(userId);
        orders.setIsActive(0);
        orders.setQuantity(0);
        int result = mapper.createShoppingCart(orders);
        if(result > 0){
            return result;
        }else{
            LOGGER.error("Error when call reNewOrder in OrdersService class: .");
            return 0;
        }
    }

    public Orders getUserIdCart(int userId){
        return mapper.getUserCart(userId);
    }

    public Orders getProduct(int orderId){
        try {
            Orders orders = mapper.getProductFromCart(orderId);
            if(orders != null){
                return orders;
            }else{
                return new Orders();
            }
        }catch (Exception e){
            LOGGER.error("Error when call addOrderProduct in OrdersController class: .", e);
            return null;
        }
    }

    public Orders getCartProductDetail(int orderId){
        try {
            Orders orders = mapper.getCartProductDetail(orderId);
            if(orders != null){
                return orders;
            }else{
                return new Orders();
            }
        }catch (Exception e){
            LOGGER.error("Error when call getCartProductDetail in OrdersController class: .", e);
            return null;
        }
    }

    public int updateOrderUser(int orderId){
        int result = mapper.updateOrder(orderId);
        try {
            if(result > 0){
                return result;
            }
        }catch (Exception e) {
            LOGGER.error("Error when call updateOrderUser in OrdersService class: .", e);
            return 0;
        }
        return result;
    }
}
