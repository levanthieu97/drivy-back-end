package com.thieu.tool.controller;


import com.thieu.tool.models.SupplierProfile;
import com.thieu.tool.services.SupplierProfileService;
import com.thieu.tool.shared.ResponseObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;

@RestController
@RequestMapping("/api/suppliers")
public class SupplierController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SupplierController.class);


    @Autowired
    private SupplierProfileService service;

    @GetMapping("/{id}")
    public ResponseObject getSupplier(@PathVariable("id") int id) {
        ResponseObject responseObject = new ResponseObject();
        try {
            SupplierProfile supplier = service.isSupplier(id);
            if (supplier != null) {
                responseObject.setData(supplier);
                responseObject.setSuccess(true);
                responseObject.setMessage("Chúc mừng bạn đã đồng hành cùng TP Shop !!!");
            } else {
                responseObject.setSuccess(false);
            }
            return responseObject;
        }catch (Exception e){
            LOGGER.error("Error when call getCategories in SupplierController class: .", e);
            return ResponseObject.FAILURE;
        }
    }

    @PostMapping("/createSupplier")
    public ResponseObject createSupplier(@Valid @RequestBody SupplierProfile supplier, @RequestParam int userId){
        ResponseObject responseObject = new ResponseObject();
        try{
            SupplierProfile supplierProfile = new SupplierProfile(supplier.getStoreName(),supplier.getBusinessCode(),supplier.getIsLicense(),supplier.getTaxCode());
            if( supplierProfile != null) {
                supplierProfile.setCreateDate(new Date());
                supplierProfile.setIsActive(1);
                supplierProfile.setUserId(userId);
                responseObject.setData(service.createSupplier(supplierProfile));
                responseObject.setSuccess(true);
                responseObject.setMessage("Xác nhận thành công !!!");
            }else {
                responseObject.setSuccess(false);
                responseObject.setMessage("Create Supplier Failed!!!");
            }
            return responseObject;

        }catch (Exception e){
            LOGGER.error("Error when call createSupplier in SupplierController class: .", e);
            return ResponseObject.FAILURE;
        }
    }

    @GetMapping("/product-no-active")
    public ResponseObject listProductNoActive(@RequestParam("supplierProfileId") int supplierProfileId){
        ResponseObject responseObject = new ResponseObject();
        try {
            SupplierProfile supplier = service.getProductNoActive(supplierProfileId);
            if (supplier != null) {
                responseObject.setData(supplier);
                responseObject.setSuccess(true);
                responseObject.setMessage("Successfully !!!");
            } else {
                responseObject.setSuccess(false);
            }
            return responseObject;
        }catch (Exception e){
            LOGGER.error("Error when call listProductNoActive in SupplierController class: .", e);
            return ResponseObject.FAILURE;
        }
    }

    @GetMapping("/product-detail-no-active")
    public ResponseObject listProductDetailNoActive(@RequestParam("supplierProfileId") int supplierProfileId){
        ResponseObject responseObject = new ResponseObject();
        try {
            SupplierProfile supplier = service.getProductDetailNoActive(supplierProfileId);
            if (supplier != null) {
                responseObject.setData(supplier);
                responseObject.setSuccess(true);
                responseObject.setMessage("Successfully !!!");
            } else {
                responseObject.setSuccess(false);
            }
            return responseObject;
        }catch (Exception e){
            LOGGER.error("Error when call listProductDetailNoActive in SupplierController class: .", e);
            return ResponseObject.FAILURE;
        }
    }


    @GetMapping("/product")
    public ResponseObject listProduct(@RequestParam("supplierProfileId") int supplierProfileId){
        ResponseObject responseObject = new ResponseObject();
        try {
            SupplierProfile supplier = service.getListProduct(supplierProfileId);
            if (supplier != null) {
                responseObject.setData(supplier);
                responseObject.setSuccess(true);
                responseObject.setMessage("Successfully !!!");
            } else {
                responseObject.setSuccess(false);
            }
            return responseObject;
        }catch (Exception e){
            LOGGER.error("Error when call listProduct in SupplierController class: .", e);
            return ResponseObject.FAILURE;
        }
    }

    @GetMapping("/product-detail-order")
    public ResponseObject listProductDetail(@RequestParam("supplierProfileId") int supplierProfileId){
        ResponseObject responseObject = new ResponseObject();
        try {
            SupplierProfile supplier = service.getListProductDetail(supplierProfileId);
            if (supplier != null) {
                responseObject.setData(supplier);
                responseObject.setSuccess(true);
                responseObject.setMessage("Successfully !!!");
            } else {
                responseObject.setSuccess(false);
            }
            return responseObject;
        }catch (Exception e){
            LOGGER.error("Error when call listProductDetail in SupplierController class: .", e);
            return ResponseObject.FAILURE;
        }
    }

    @GetMapping("count-product")
    public ResponseObject quantityProduct(@RequestParam int supplierProfileId){
        ResponseObject responseObject = new ResponseObject();
        try {
            int result = service.countProductQuantity(supplierProfileId);
            if (result >= 0) {
                responseObject.setData(result);
                responseObject.setSuccess(true);
                responseObject.setMessage("Successfully !!!");
            } else {
                responseObject.setSuccess(false);
            }
            return responseObject;
        }catch (Exception e){
            LOGGER.error("Error when call quantityProduct in SupplierController class: .", e);
            return ResponseObject.FAILURE;
        }
    }


}
