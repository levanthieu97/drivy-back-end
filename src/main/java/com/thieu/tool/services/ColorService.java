package com.thieu.tool.services;

import com.thieu.tool.mappers.ColorMapper;
import com.thieu.tool.models.Colors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ColorService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ColorService.class);

    @Autowired
    private ColorMapper mapper;

    public List<Colors> requestAllColor(){
        List<Colors> colors = mapper.getAllColor();
        if(colors != null){
            return colors;
        }else{
            LOGGER.error("Error when call requestAllColor in ColorService class: .");
            return null;
        }
    }

}
