package com.thieu.tool.mappers;

import com.thieu.tool.models.ProductDetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ProductDetailMapper {
    int addProductDistinct(@Param("list")List<ProductDetail> detail);

    int updateQuantityProductDetail(@Param("quantity") int quantity, @Param("productDetailId") int productDetailId);

    int resetQuantityProductDetail(@Param("productDetailId") int productDetailId);

    List<ProductDetail> showProductDetail(@Param("productId") int productId);

}
