package com.thieu.tool.controller;

import com.thieu.tool.models.CategorySetting;
import com.thieu.tool.services.CategorySettingService;
import com.thieu.tool.shared.ResponseObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/all")
public class CategorySettingController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CategorySettingController.class);

    @Autowired
    private CategorySettingService service;

    @GetMapping("/category-setting/{id}")
    private ResponseObject getNameCateSetting(@PathVariable("id") int id){
        ResponseObject responseObject = new ResponseObject();
        try{
            List<CategorySetting> categorySetting = service.getCateSetting(id);
            if(categorySetting != null) {
                responseObject.setData(categorySetting);
                responseObject.setSuccess(true);
                responseObject.setMessage("message Successfully!");
            }else{
                responseObject.setSuccess(false);
            }
            return responseObject;
        }catch(Exception e){
            LOGGER.error("Error when call createSupPro in SupplierProductController class: .", e);
            return responseObject.FAILURE;
        }
    }

    @GetMapping("/setting-detail")
    public ResponseObject getSettingDetail(){
        ResponseObject responseObject = new ResponseObject();
        try{
            List<CategorySetting> listOption = service.getDetail();
            if(listOption != null) {
                responseObject.setData(listOption);
                responseObject.setSuccess(true);
                responseObject.setMessage("message Successfully!");
            }else{
                responseObject.setSuccess(false);
            }
            return responseObject;
        }catch(Exception e){
            LOGGER.error("Error when call getOption in OptionAttributeController class: .", e);
            return responseObject.FAILURE;
        }
    }

    @GetMapping("/setting-name")
    public ResponseObject getNameCateSetting(){
        ResponseObject responseObject = new ResponseObject();
        try{
            List<CategorySetting> listOption = service.getNameSetting();
            if(listOption != null) {
                responseObject.setData(listOption);
                responseObject.setSuccess(true);
                responseObject.setMessage("message Successfully!");
            }else{
                responseObject.setSuccess(false);
            }
            return responseObject;
        }catch(Exception e){
            LOGGER.error("Error when call getNameSetting in OptionAttributeController class: .", e);
            return responseObject.FAILURE;
        }
    }

    @GetMapping("/name-setting-detail/{settingName}")
    public ResponseObject getNameSettingDetail(@PathVariable("settingName") String settingName){
        ResponseObject responseObject = new ResponseObject();
        try {
            List<CategorySetting> listOption = service.getNameForSettingDetail(settingName);
            if(listOption != null) {
                responseObject.setData(listOption);
                responseObject.setSuccess(true);
                responseObject.setMessage("message Successfully!");
            }else{
                responseObject.setSuccess(false);
            }
            return responseObject;
        }catch (Exception e){
            LOGGER.error("Error when call getNameSettingDetail in OptionAttributeController class: .", e);
            return responseObject.FAILURE;
        }
    }

    @GetMapping("/scrums/{settingName}")
    public ResponseObject getScrums(@PathVariable("settingName") String settingName){
        ResponseObject responseObject = new ResponseObject();
        try {
            CategorySetting categorySetting = service.getScrumsCategory(settingName);
            if(categorySetting != null) {
                responseObject.setData(categorySetting);
                responseObject.setSuccess(true);
                responseObject.setMessage("message Successfully!");
            }else{
                responseObject.setSuccess(false);
            }
            return responseObject;
        }catch (Exception e){
            LOGGER.error("Error when call getNameSettingDetail in OptionAttributeController class: .", e);
            return responseObject.FAILURE;
        }
    }

}
