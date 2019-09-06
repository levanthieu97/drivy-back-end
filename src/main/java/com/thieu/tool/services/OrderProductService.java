package com.thieu.tool.services;

import com.thieu.tool.mappers.OrderProductMapper;
import com.thieu.tool.models.OrderProduct;
import com.thieu.tool.shared.CommonStrings;
import com.thieu.tool.shared.ResponseObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderProductService {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderProductService.class);

    @Autowired
    private OrderProductMapper mapper;

    public ResponseObject createOrderProduct(OrderProduct orderProduct) {
        ResponseObject responseObject = new ResponseObject();
        try {
            int result = mapper.addOrderProduct(orderProduct);
            if (result > 0) {
                responseObject.setSuccess(true);
                responseObject.setMessage(CommonStrings.RESP_MSG_SUCCESS);
            } else {
                responseObject.setSuccess(false);
                responseObject.setMessage(CommonStrings.RESP_MSG_SERVER_ERROR);
            }
            return responseObject;
        } catch (Exception e) {
            LOGGER.error("Error when call createOrderProduct in OrderProductService class: .");
            return ResponseObject.FAILURE;
        }
    }

    public ResponseObject updateProduct(OrderProduct orderProduct) {
        ResponseObject responseObject = new ResponseObject();
        try {
            int result = mapper.updateQuantity(orderProduct);
            if (result > 0) {
                responseObject.setSuccess(true);
                responseObject.setMessage(CommonStrings.RESP_MSG_SUCCESS);
            } else {
                responseObject.setSuccess(false);
                responseObject.setMessage(CommonStrings.RESP_MSG_SERVER_ERROR);
            }
            return responseObject;
        } catch (Exception e) {
            LOGGER.error("Error when call createOrderProduct in OrderProductService class: .");
            return ResponseObject.FAILURE;
        }
    }

    public OrderProduct getInfoProduct(OrderProduct orderProduct) {
        OrderProduct service = mapper.checkExistProduct(orderProduct);
        if (service != null) {
            return service;
        } else {
//            LOGGER.error("Error when call getImageProduct in ImageOfProductService class: .");
            return null;
        }
    }

    public OrderProduct countNumberCart(int orderId) {
        OrderProduct service = mapper.countProduct(orderId);
        if (service != null) {
            return service;
        } else {
            LOGGER.error("Error when call countNumberCart in ImageOfProductService class: .");
            return null;
        }
    }

    public int removeProduct(int orderItemId) {
        int result = mapper.removeProductFromMyCart(orderItemId);
        if (result > 0) {
            return result;
        } else {
            LOGGER.error("Error when call removeProduct in ImageOfProductService class: .");
            return 0;
        }

    }

}
