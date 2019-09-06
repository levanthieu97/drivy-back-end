package com.thieu.tool.mappers;

import com.thieu.tool.models.Colors;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ColorMapper {
    List<Colors> getAllColor();
}
