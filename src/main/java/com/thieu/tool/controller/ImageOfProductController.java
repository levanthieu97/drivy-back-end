package com.thieu.tool.controller;

import com.thieu.tool.models.ImageOfProduct;
import com.thieu.tool.services.ImageOfProductService;
import com.thieu.tool.shared.ResponseObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api/image/")
public class ImageOfProductController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ImageOfProductController.class);

    @Autowired
    private ImageOfProductService service;

    @GetMapping("product/{productName}")
    public ResponseObject ImageProject(@PathVariable("productName") String productName){
        ResponseObject responseObject = new ResponseObject();
        try {
            ImageOfProduct imageOfProduct = service.getImageProduct(productName);
            if(imageOfProduct != null){
                responseObject.setData(imageOfProduct);
                responseObject.setSuccess(true);
                responseObject.setMessage("message Successfully!");
            }else{
                responseObject.setSuccess(false);
            }
            return responseObject;
        }catch (Exception e){
            LOGGER.error("Error when call ImageProject in ImageOfProductController class: .", e);
            return responseObject.FAILURE;
        }
    }
}
