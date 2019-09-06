package com.thieu.tool.mappers;

import com.thieu.tool.models.ProductCategory;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ProductCategoryMapper {

    ProductCategory getScrumsFromProduct(@Param("productName") String productName);
}
