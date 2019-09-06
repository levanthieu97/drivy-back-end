//package com.thieu.tool.controller;
//
//import com.thieu.tool.models.ProductCatalog;
//import com.thieu.tool.services.ProductCatalogService;
//import com.thieu.tool.shared.ResponseObject;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import javax.validation.Valid;
//
//@RestController
//@RequestMapping("api/products/")
//public class ProductCatalogController {
//
//    private static final Logger LOGGER = LoggerFactory.getLogger(ProductCatalogController.class);
//
//
//    @Autowired
//    private ProductCatalogService service;
//
//    @PostMapping("product-catalog")
//    public ResponseObject addProductCatalog(@Valid @RequestBody ProductCatalog productCatalog){
//        ResponseObject responseObject = new ResponseObject();
//        try{
//            ProductCatalog newProductCatalog = new ProductCatalog(productCatalog.getProductId(),productCatalog.getCatalogId());
//            if(newProductCatalog != null){
//                responseObject.setData(service.createProductCatalog(newProductCatalog));
//                responseObject.setSuccess(true);
//                responseObject.setMessage("Tạo sản phẩm thành công !!!");
//            }else{
//                responseObject.setSuccess(false);
//                responseObject.setMessage("Create product Failed!!!");
//            }
//            return responseObject;
//        }catch (Exception e){
//            LOGGER.error("Error when call addProductCatalog in ProductCatalogController class: .", e);
//            return ResponseObject.FAILURE;
//        }
//    }
//
//}
