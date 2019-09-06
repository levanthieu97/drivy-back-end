package com.thieu.tool.services;

import com.thieu.tool.mappers.CityMapper;
import com.thieu.tool.models.City;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {
    private static final Logger LOGGER = LoggerFactory.getLogger(CityService.class);

    @Autowired
    private CityMapper mapper;

    public List<City> getCity(){
        List<City> result = mapper.getCityName();
        if(result != null){
            return result;
        }else{
            return null;
        }
    }


}
