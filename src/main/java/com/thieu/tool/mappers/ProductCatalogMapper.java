package com.thieu.tool.mappers;

import com.thieu.tool.models.ProductCatalog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ProductCatalogMapper {
    int addProductCatalog(@Param("list") List<ProductCatalog> catalog);
}
