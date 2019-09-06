package com.thieu.tool.controller;

import com.thieu.tool.models.CategoryCatalog;
import com.thieu.tool.services.CategoryCatalogService;
import com.thieu.tool.shared.ResponseObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("api/category-catalog")
public class CategoryCatalogController {
    private static final Logger LOGGER = LoggerFactory.getLogger(CategoryCatalogController.class);

    @Autowired
    private CategoryCatalogService service;

    @GetMapping("/get-catalog/{detailType}")
    public ResponseObject getCatalog(@PathVariable("detailType") String detailType){
        ResponseObject responseObject = new ResponseObject();
        try{
            List<CategoryCatalog> categoryCatalog = service.requestNameCatalog(detailType);
            if(categoryCatalog != null){
                responseObject.setData(categoryCatalog);
                responseObject.setSuccess(true);
                responseObject.setMessage("message Successfully!");
            }else{
                responseObject.setSuccess(false);
            }
            return responseObject;
        }catch (Exception e){
            LOGGER.error("Error when call requestCatalog in CategoryCatalogController class: .", e);
            return responseObject.FAILURE;
        }
    }



}
