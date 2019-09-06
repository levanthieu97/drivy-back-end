package com.thieu.tool.mappers;

import com.thieu.tool.models.Category;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CategoryMapper {

    List<Category> requestCategory();
}
