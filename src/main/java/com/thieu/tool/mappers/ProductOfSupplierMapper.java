package com.thieu.tool.mappers;

import com.thieu.tool.models.ProductOfSupplier;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


@Mapper
@Repository
public interface ProductOfSupplierMapper {

    ProductOfSupplier getSupplierProduct(@Param("productName") String productName);

    ProductOfSupplier getSupplierProductDetail(@Param("productName") String productName, @Param("productDetailId") int productDetailId);
}
