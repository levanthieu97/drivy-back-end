package com.thieu.tool.controller;

import com.thieu.tool.models.ProductAndCatalogType;
import com.thieu.tool.services.ProductAndCatalogTypeService;
import com.thieu.tool.shared.ResponseObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/catalog-product/")
public class ProductAndCatalogTypeController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductAndCatalogTypeController.class);

    @Autowired
    private ProductAndCatalogTypeService service;

    @GetMapping("{productName}")
    public ResponseObject getListCatalogProduct(@PathVariable("productName") String productName){
        ResponseObject responseObject = new ResponseObject();
        try {
            ProductAndCatalogType products = service.ProductAndCatalogType(productName);
            if(products != null){
                responseObject.setData(products);
                responseObject.setSuccess(true);
                responseObject.setMessage("Search Successfully !!!");
            } else {
                responseObject.setSuccess(false);
            }
            return responseObject;
        } catch (Exception e){
            LOGGER.error("Error when call getListCatalogProduct in ProductAndCatalogTypeController class: .", e);
            return ResponseObject.FAILURE;
        }
    }


}
