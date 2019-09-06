package com.thieu.tool.controller;

import com.thieu.tool.models.Category;
import com.thieu.tool.services.CategoryService;
import com.thieu.tool.shared.ResponseObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/category")
public class CategoryController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CategoryController.class);

    @Autowired
    private CategoryService service;

    @GetMapping("/all")
    public ResponseObject getCategory(){
        ResponseObject responseObject = new ResponseObject();
        try {
            List<Category> listCategory = service.requestCategory();
            if(listCategory != null){
                responseObject.setData(listCategory);
                responseObject.setSuccess(true);
                responseObject.setMessage("message Successfully!");
            }else{
                responseObject.setSuccess(false);
            }
            return responseObject;
        }catch (Exception e){
            LOGGER.error("Error when call getNameCategory in CategoryController class: .", e);
            return responseObject.FAILURE;
        }
    }
}
