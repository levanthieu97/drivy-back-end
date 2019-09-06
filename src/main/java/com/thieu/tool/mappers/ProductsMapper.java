package com.thieu.tool.mappers;


import com.thieu.tool.models.Products;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ProductsMapper {

    List<Products> searchProducts(@Param("productName") String productName);

    List<Products> requestProduct(@Param("cateDetailsType") String cateDetailsType);

    int createProduct(Products products);

    List<Products> getDataProduct();

    List<Products> getListProductFromSetting(@Param("settingName") String settingName);

    List<Products> getListProductCategoryDetail(@Param("cateDetailsType") String typeDetail);

    Products getListProductDetail(@Param("productName") String productName);

    Products getInfoProductByProductName(@Param("productName") String productName);

    int updateQuantityProduct(@Param("productQuantity") int productQuantity, @Param("productId") int productId);

    int resetQuantityProduct(@Param("productId") int productId);

    List<Products> searchProductsByName(@Param("productName") String productName);

    int checkNameProduct(@Param("productNameCompare") String productNameCompare);
}
