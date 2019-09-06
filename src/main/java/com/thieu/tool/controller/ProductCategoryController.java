package com.thieu.tool.controller;

import com.thieu.tool.models.ProductCategory;
import com.thieu.tool.services.ProductCategoryService;
import com.thieu.tool.shared.ResponseObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/suggest-category/")
public class ProductCategoryController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductCategoryController.class);

    @Autowired
    private ProductCategoryService service;

    @GetMapping("product/{productName}")
    public ResponseObject suggestScrumCategory(@PathVariable("productName") String productName){
        ResponseObject responseObject = new ResponseObject();
        try{
            ProductCategory productCategory = service.getScrums(productName);
            if(productCategory != null){
                responseObject.setData(productCategory);
                responseObject.setSuccess(true);
                responseObject.setMessage("message Successfully!");
            }else {
                responseObject.setSuccess(false);
            }
               return responseObject;
        }catch (Exception e){
            LOGGER.error("Error when call suggestScrumCategory in ProductCategoryController class: .", e);
            return responseObject.FAILURE;
        }
    }
}
