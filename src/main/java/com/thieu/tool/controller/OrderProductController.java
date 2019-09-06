package com.thieu.tool.controller;

import com.sun.deploy.security.ruleset.ExceptionRule;
import com.thieu.tool.models.OrderProduct;
import com.thieu.tool.services.OrderProductService;
import com.thieu.tool.shared.ResponseObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/order-product/")
public class OrderProductController {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderProductController.class);

    @Autowired
    private OrderProductService service;


    @PostMapping("order")
    public ResponseObject addOrderProduct(@Valid @RequestBody OrderProduct orderProduct){
        ResponseObject responseObject = new ResponseObject();
        try{
            OrderProduct result = new OrderProduct(orderProduct.getOrderId(),orderProduct.getProductId()
                    ,orderProduct.getProductDetailId(),orderProduct.getSupplierProfileId(),orderProduct.getStoreName(),orderProduct.getProductQuantity());
            if(result != null){
                responseObject.setData(service.createOrderProduct(result));
                responseObject.setSuccess(true);
                responseObject.setMessage("Successfully !!!");
            }else{
                responseObject.setSuccess(false);
                responseObject.setMessage("Failed!!!");
            }
            return responseObject;
        }catch (Exception e){
            LOGGER.error("Error when call requestInfoProduct in OrderProductController class: .", e);
            return ResponseObject.FAILURE;
        }
    }

    @PutMapping("update-quantity")
    public ResponseObject updateProductQuantity(@RequestBody OrderProduct orderProduct){
        ResponseObject responseObject = new ResponseObject();
        try{
            OrderProduct result = new OrderProduct(orderProduct.getOrderId(),orderProduct.getProductId()
                    ,orderProduct.getProductDetailId(),orderProduct.getSupplierProfileId(),orderProduct.getStoreName(),orderProduct.getProductQuantity());
            if(result != null){
                responseObject.setData(service.updateProduct(result));
                responseObject.setSuccess(true);
                responseObject.setMessage("Successfully !!!");
            }else{
                responseObject.setSuccess(false);
                responseObject.setMessage("Failed!!!");
            }
            return responseObject;
        }catch (Exception e){
            LOGGER.error("Error when call updateProductQuantity in OrderProductController class: .", e);
            return ResponseObject.FAILURE;
        }
    }

    @PostMapping("check-product")
    public ResponseObject checkInfoProduct(@Valid @RequestBody OrderProduct orderProduct){
        ResponseObject responseObject = new ResponseObject();
        try{
            OrderProduct result = service.getInfoProduct(orderProduct);
            if(result != null){
                responseObject.setData(result);
                responseObject.setSuccess(true);
                responseObject.setMessage("message Successfully!");
            }else{
                responseObject.setSuccess(false);
            }
            return responseObject;
        }catch (Exception e){
            LOGGER.error("Error when call checkInfoProduct in OrderProductController class: .", e);
            return ResponseObject.FAILURE;
        }
    }


    @GetMapping("count-cart")
    public ResponseObject countCart(@RequestParam int orderId){
        ResponseObject responseObject = new ResponseObject();
        try{
            OrderProduct result = service.countNumberCart(orderId);
            if(result != null){
                responseObject.setData(result);
                responseObject.setSuccess(true);
                responseObject.setMessage("message Successfully!");
            }else{
                responseObject.setSuccess(false);
            }
            return responseObject;
        }catch (Exception e){
            LOGGER.error("Error when call countCart in OrderProductController class: .", e);
            return ResponseObject.FAILURE;
        }
    }

    @DeleteMapping("remove-product")
    public ResponseObject deleteProduct(@RequestParam int orderItemId){
        ResponseObject responseObject = new ResponseObject();
        try{
            int result = service.removeProduct(orderItemId);
            if(result > 0){
                responseObject.setData(result);
                responseObject.setSuccess(true);
                responseObject.setMessage("message Successfully!");
            }else{
                responseObject.setSuccess(false);
            }
            return responseObject;
        }catch (Exception e){
            LOGGER.error("Error when call deleteProduct in OrderProductController class: .", e);
            return ResponseObject.FAILURE;
        }
    }
}
