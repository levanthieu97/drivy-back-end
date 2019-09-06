package com.thieu.tool.services;


import com.thieu.tool.mappers.ImageOfProductMapper;
import com.thieu.tool.models.ImageOfProduct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImageOfProductService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ImageOfProductService.class);

    @Autowired
    private ImageOfProductMapper mapper;

    public ImageOfProduct getImageProduct(String productName){
        ImageOfProduct service =  mapper.getImageProduct(productName);
        if(service != null){
            return service;
        }else{
            LOGGER.error("Error when call getImageProduct in ImageOfProductService class: .");
            return null;
        }
    }

}
