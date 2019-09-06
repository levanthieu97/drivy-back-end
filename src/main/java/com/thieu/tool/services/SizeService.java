package com.thieu.tool.services;

import com.thieu.tool.mappers.SizeMapper;
import com.thieu.tool.models.Size;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SizeService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SizeService.class);

    @Autowired
    private SizeMapper mapper;

    public List<Size> requestAllSize(){
        List<Size> sizes = mapper.getAllSize();
        if(sizes != null){
            return sizes;
        }else{
            LOGGER.error("Error when call requestAllSize in SizeService class: .");
            return null;
        }
    }
}
