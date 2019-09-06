package com.thieu.tool.mappers;

import com.thieu.tool.models.Orders;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface OrdersMapper {

    int createShoppingCart(Orders orders);

    Orders getUserCart(@Param("userId") int userId);

    Orders getProductFromCart(@Param("orderId") int orderId);

    Orders getCartProductDetail(@Param("orderId") int orderId);

    int updateOrder(@Param("orderId") int orderId);
}
