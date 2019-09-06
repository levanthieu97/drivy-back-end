package com.thieu.tool.controller;

import com.thieu.tool.models.ProductOfSupplier;
import com.thieu.tool.services.ProductOfSupplierService;
import com.thieu.tool.shared.ResponseObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/supplier-product/")
public class ProductOfSupplierController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductOfSupplierController.class);

    @Autowired
    private ProductOfSupplierService service;

    @GetMapping("{productName}")
    public ResponseObject requestSupplierProduct(@PathVariable("productName") String productName){
        ResponseObject responseObject = new ResponseObject();
        try{
            ProductOfSupplier products = service.suggestSupplier(productName);
            if(products != null){
                responseObject.setData(products);
                responseObject.setSuccess(true);
                responseObject.setMessage("Search Successfully !!!");
            } else {
                responseObject.setSuccess(false);
            }
            return responseObject;
        }catch (Exception e){
            LOGGER.error("Error when call requestSupplierProduct in ProductsController class: .", e);
            return ResponseObject.FAILURE;
        }
    }

    @GetMapping("{productName}/product")
    public ResponseObject requestSupplierProduct(@PathVariable("productName") String productName, @RequestParam int productDetailId){
        ResponseObject responseObject = new ResponseObject();
        try{
            ProductOfSupplier products = service.supplierProductDetail(productName,productDetailId);
            if(products != null){
                responseObject.setData(products);
                responseObject.setSuccess(true);
                responseObject.setMessage("Search Successfully !!!");
            } else {
                responseObject.setSuccess(false);
            }
            return responseObject;
        }catch (Exception e){
            LOGGER.error("Error when call requestSupplierProduct in ProductsController class: .", e);
            return ResponseObject.FAILURE;
        }
    }

}
