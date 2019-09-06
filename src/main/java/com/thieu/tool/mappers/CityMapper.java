package com.thieu.tool.mappers;


import com.thieu.tool.models.City;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CityMapper {

    List<City> getCityName();
}
