package com.thieu.tool.services;

import com.thieu.tool.mappers.ProductCategoryMapper;
import com.thieu.tool.models.ProductCategory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductCategoryService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductCategoryService.class);

    @Autowired
    private ProductCategoryMapper mapper;

    public ProductCategory getScrums(String productName) {
        ProductCategory service = mapper.getScrumsFromProduct(productName);
        if (service != null) {
            return service;
        } else {
            LOGGER.error("Error when call getScrums in ProductCategoryService class: .");
            return null;
        }
    }

}
