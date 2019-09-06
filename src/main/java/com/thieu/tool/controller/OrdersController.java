package com.thieu.tool.controller;


import com.thieu.tool.models.Orders;
import com.thieu.tool.services.OrdersService;
import com.thieu.tool.shared.ResponseObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/shopping-cart/")
public class OrdersController {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrdersController.class);

    @Autowired
    private OrdersService service;


    @GetMapping("new-cart/{userId}")
    public ResponseObject addOrderProduct(@PathVariable("userId") int userId){
        ResponseObject responseObject = new ResponseObject();
        try{
            Orders orders = service.getUserIdCart(userId);
            if(orders != null){
                responseObject.setData(orders);
                responseObject.setSuccess(true);
                responseObject.setMessage("Successfully !!!");
            }else{
                responseObject.setSuccess(false);
                responseObject.setMessage("Failed!!!");
            }
            return responseObject;
        }catch (Exception e){
            LOGGER.error("Error when call addOrderProduct in OrdersController class: .", e);
            return ResponseObject.FAILURE;
        }
    }


    @GetMapping("product-cart/{orderId}")
    public ResponseObject productCart(@PathVariable("orderId") int orderId){
        ResponseObject responseObject = new ResponseObject();
        try{
            Orders orders = service.getProduct(orderId);
            if(orders != null){
                responseObject.setData(orders);
                responseObject.setSuccess(true);
                responseObject.setMessage("Successfully !!!");
            }else{
                responseObject.setSuccess(false);
                responseObject.setMessage("Failed!!!");
            }
            return responseObject;
        }catch (Exception e){
            LOGGER.error("Error when call productCart in OrdersController class: .", e);
            return ResponseObject.FAILURE;
        }
    }


    @GetMapping("product-detail-cart/{orderId}")
    public ResponseObject getProductDetail(@PathVariable int orderId){
        ResponseObject responseObject = new ResponseObject();
        try{
            Orders orders = service.getCartProductDetail(orderId);
            if(orders != null){
                responseObject.setData(orders);
                responseObject.setSuccess(true);
                responseObject.setMessage("Successfully !!!");
            }else{
                responseObject.setSuccess(false);
                responseObject.setMessage("Failed!!!");
            }
            return responseObject;
        }catch (Exception e){
            LOGGER.error("Error when call getProductDetail in OrdersController class: .", e);
            return ResponseObject.FAILURE;
        }
    }

    @PutMapping("update-orders")
    public ResponseObject updateOrder(@RequestParam int orderId){
        ResponseObject responseObject = new ResponseObject();
        try{
            int result = service.updateOrderUser(orderId);
            if(result > 0){
                responseObject.setData(result);
                responseObject.setSuccess(true);
                responseObject.setMessage("Successfully !!!");
            }else{
                responseObject.setSuccess(false);
                responseObject.setMessage("Fail !!!");
            }
            return responseObject;
        }catch (Exception e){
            LOGGER.error("Error when call updateOrder in OrdersController class: .", e);
            return responseObject.FAILURE;
        }
    }

    @PostMapping("renew-order")
    public ResponseObject renewOrderUser(@RequestParam int userId){
        ResponseObject responseObject = new ResponseObject();
        try{
            int result = service.reNewOrder(userId);
            if(result > 0){
                responseObject.setData(result);
                responseObject.setSuccess(true);
                responseObject.setMessage("Successfully !!!");
            }else{
                responseObject.setSuccess(false);
                responseObject.setMessage("Fail !!!");
            }
            return responseObject;
        }catch (Exception e){
            LOGGER.error("Error when call renewOrderUser in OrdersController class: .", e);
            return responseObject.FAILURE;
        }
    }
}
