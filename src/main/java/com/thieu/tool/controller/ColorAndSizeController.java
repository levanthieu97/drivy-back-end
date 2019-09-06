package com.thieu.tool.controller;


import com.thieu.tool.models.Colors;
import com.thieu.tool.models.Size;
import com.thieu.tool.services.ColorService;
import com.thieu.tool.services.SizeService;
import com.thieu.tool.shared.ResponseObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/products")
public class ColorAndSizeController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ColorAndSizeController.class);

    @Autowired
    private ColorService colorService;

    @Autowired
    private SizeService sizeService;

    @GetMapping("/color")
    public ResponseObject getColors(){
        ResponseObject responseObject =new ResponseObject();
        try{
            List<Colors> colors = colorService.requestAllColor();
            if(colors != null){
                responseObject.setData(colors);
                responseObject.setSuccess(true);
                responseObject.setMessage("Get data colors successfully!");
            }else{
                responseObject.setSuccess(false);
            }
            return responseObject;

        }catch (Exception e){
            LOGGER.error("Error when call getColors in ColorAndSizeController class: .", e);
            return ResponseObject.FAILURE;
        }
    }

    @GetMapping("/size")
    public ResponseObject getSize(){
        ResponseObject responseObject =new ResponseObject();
        try{
            List<Size> sizes = sizeService.requestAllSize();
            if(sizes != null){
                responseObject.setData(sizes);
                responseObject.setSuccess(true);
                responseObject.setMessage("Get data colors successfully!");
            }else{
                responseObject.setSuccess(false);
            }
            return responseObject;

        }catch (Exception e){
            LOGGER.error("Error when call getColors in ColorAndSizeController class: .", e);
            return ResponseObject.FAILURE;
        }
    }

}
