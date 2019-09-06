package com.thieu.tool.services;

import com.thieu.tool.mappers.ProductAndCatalogTypeMapper;
import com.thieu.tool.models.ProductAndCatalogType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductAndCatalogTypeService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductAndCatalogTypeService.class);

    @Autowired
    private ProductAndCatalogTypeMapper mapper;

    public ProductAndCatalogType ProductAndCatalogType(String productName){
        ProductAndCatalogType service = mapper.listCatalogOfProduct(productName);
        if(service != null){
            return service;
        }else{
            LOGGER.error("Error when call ProductAndCatalogType in ProductAndCatalogTypeService class: .");
            return null;
        }
    }

}
