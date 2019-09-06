package com.thieu.tool.services;

import com.thieu.tool.mappers.CategoryDetailsMapper;
import com.thieu.tool.models.CategoryDetails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryDetailService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CategoryDetailService.class);

    @Autowired
    private CategoryDetailsMapper mapper;

    public List<CategoryDetails> suggestItem(String nameDetail){
        List<CategoryDetails> service = mapper.suggestCatalog(nameDetail);
        if(service != null){
            return service;
        }else{
            LOGGER.error("Error when call suggestItem in CategoryDetailService class: .");
            return null;
        }
    }

    public List<CategoryDetails> suggestListSupplier(String cateDetailsType){
        List<CategoryDetails> service = mapper.suggestSupplier(cateDetailsType);
        if(service != null){
            return service;
        }else{
            LOGGER.error("Error when call suggestListSupplier in CategoryDetailService class: .");
            return null;
        }
    }

}
