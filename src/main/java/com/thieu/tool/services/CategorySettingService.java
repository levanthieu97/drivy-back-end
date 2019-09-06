package com.thieu.tool.services;

import com.thieu.tool.mappers.CategorySettingMapper;
import com.thieu.tool.models.CategorySetting;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategorySettingService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CategorySettingService.class);


    @Autowired
    private CategorySettingMapper settingMapper;

    public List<CategorySetting> getCateSetting(int categoryId){
        List<CategorySetting> service = settingMapper.getCategorySetting(categoryId);
        if(service != null){
            return service;
        }else{
            LOGGER.error("Error when call getCateSetting in CategorySettingService class: .");
            return null;
        }
    }

    public List<CategorySetting> getDetail(){
        return settingMapper.getSettingDetail();
    }

    public List<CategorySetting> getNameSetting(){
        List<CategorySetting> service = settingMapper.getNameCateSetting();
        if(service != null){
            return service;
        }else{
            LOGGER.error("Error when call getNameSetting in CategorySettingService class: .");
            return null;
        }
    }


    public List<CategorySetting> getNameForSettingDetail(String name){
        List<CategorySetting> service = settingMapper.getNameForSettingDetail(name);
        if(service != null){
            return service;
        }else{
            LOGGER.error("Error when call getNameForSettingDetail in CategorySettingService class: .");
            return null;
        }
    }

    public CategorySetting getScrumsCategory(String name){
        CategorySetting service = settingMapper.getCrumsCategory(name);
        if(service != null){
            return service;
        }else{
            LOGGER.error("Error when call getNameForSettingDetail in CategorySettingService class: .");
            return null;
        }
    }

}
