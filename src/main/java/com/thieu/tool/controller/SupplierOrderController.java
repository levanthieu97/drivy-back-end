package com.thieu.tool.controller;


import com.thieu.tool.models.SupplierOrder;
import com.thieu.tool.services.SupplierOrderService;
import com.thieu.tool.shared.ResponseObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/supplier-order/")
public class SupplierOrderController {
    private static final Logger LOGGER = LoggerFactory.getLogger(SupplierOrderController.class);

    @Autowired
    private SupplierOrderService service;

    @GetMapping("supplier")
    public ResponseObject getListProduct(@RequestParam int supplierProfileId){
        ResponseObject responseObject = new ResponseObject();
        try {
            List<SupplierOrder> products = service.listProductForSupplier(supplierProfileId);
            if (products != null) {
                responseObject.setData(products);
                responseObject.setSuccess(true);
                responseObject.setMessage("Search Successfully !!!");
            } else {
                responseObject.setSuccess(false);
            }
            return responseObject;
        } catch (Exception e) {
            LOGGER.error("Error when call getListProduct in SupplierOrderController class: .", e);
            return ResponseObject.FAILURE;
        }
    }
    @GetMapping("product")
    public ResponseObject getListProductOrder(@RequestParam int paymentId,@RequestParam int supplierProfileId){
        ResponseObject responseObject = new ResponseObject();
        try {
            SupplierOrder products = service.getListProduct(paymentId,supplierProfileId);
            if (products != null) {
                responseObject.setData(products);
                responseObject.setSuccess(true);
                responseObject.setMessage("Search Successfully !!!");
            } else {
                responseObject.setSuccess(false);
            }
            return responseObject;
        } catch (Exception e) {
            LOGGER.error("Error when call getListProductOrder in SupplierOrderController class: .", e);
            return ResponseObject.FAILURE;
        }
    }



    @GetMapping("product-detail")
    public ResponseObject getListProductDetailOrder(@RequestParam int paymentId,@RequestParam int supplierProfileId){
        ResponseObject responseObject = new ResponseObject();
        try {
            SupplierOrder products = service.getListProductDetail(paymentId,supplierProfileId);
            if (products != null) {
                responseObject.setData(products);
                responseObject.setSuccess(true);
                responseObject.setMessage("Search Successfully !!!");
            } else {
                responseObject.setSuccess(false);
            }
            return responseObject;
        } catch (Exception e) {
            LOGGER.error("Error when call getListProductDetailOrder in SupplierOrderController class: .", e);
            return ResponseObject.FAILURE;
        }
    }

}
