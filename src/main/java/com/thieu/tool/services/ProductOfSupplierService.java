package com.thieu.tool.services;

import com.thieu.tool.mappers.ProductOfSupplierMapper;
import com.thieu.tool.models.ProductOfSupplier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProductOfSupplierService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductOfSupplierService.class);


    @Autowired
    private ProductOfSupplierMapper productOfSupplierMapper;

    public ProductOfSupplier suggestSupplier(String nameProduct){
        ProductOfSupplier service = productOfSupplierMapper.getSupplierProduct(nameProduct);
        if(service != null){
            return service;
        }else{
            LOGGER.error("Error when call getListProductDetail in ProductsService class: .");
            return null;
        }
    }

    public ProductOfSupplier supplierProductDetail(String nameProduct, int productDetailId){
        ProductOfSupplier service = productOfSupplierMapper.getSupplierProductDetail(nameProduct,productDetailId);
        if(service != null){
            return service;
        }else{
            return new ProductOfSupplier();
        }
    }

}
