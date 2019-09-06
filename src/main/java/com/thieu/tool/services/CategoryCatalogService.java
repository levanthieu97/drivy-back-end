package com.thieu.tool.services;

import com.thieu.tool.mappers.CategoryCatalogMapper;
import com.thieu.tool.models.CategoryCatalog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryCatalogService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CategoryCatalogService.class);

    @Autowired
    private CategoryCatalogMapper mapper;

    public List<CategoryCatalog> requestNameCatalog(String detailType){
        List<CategoryCatalog> service = mapper.requestCatalog(detailType);
        if(service != null){
            return service;
        }else{
            LOGGER.error("Error when call requestCategoryCatalog in CategoryCatalogService class: .");
            return null;
        }
    }

}
