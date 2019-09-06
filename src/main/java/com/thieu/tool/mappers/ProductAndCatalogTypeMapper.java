package com.thieu.tool.mappers;

import com.thieu.tool.models.ProductAndCatalogType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ProductAndCatalogTypeMapper {
    ProductAndCatalogType listCatalogOfProduct(@Param("productName") String productName);
}
