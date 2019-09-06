package com.thieu.tool.services;

import com.thieu.tool.mappers.CategoryMapper;
import com.thieu.tool.models.Category;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CategoryService.class);


    @Autowired
    private CategoryMapper categoryMapper;


    public List<Category> requestCategory(){
        List<Category> service = categoryMapper.requestCategory();
        if(service != null){
            return service;
        }else{
            LOGGER.error("Error when call searchProducts in ProductsService class: .");
            return null;
        }

    }
}
