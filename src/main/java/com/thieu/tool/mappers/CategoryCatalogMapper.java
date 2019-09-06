package com.thieu.tool.mappers;

import com.thieu.tool.models.CategoryCatalog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CategoryCatalogMapper {
    List<CategoryCatalog> requestCatalog(@Param("detailType") String detailType);
}
