package com.thieu.tool.mappers;

import com.thieu.tool.models.OrderProduct;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface OrderProductMapper {

    int addOrderProduct(OrderProduct orderProduct);

    int updateQuantity(OrderProduct orderProduct);

    OrderProduct checkExistProduct(OrderProduct orderProduct);

    OrderProduct countProduct(@Param("orderId") int orderId);

    int removeProductFromMyCart(@Param("orderItemId") int orderItemId);
}
