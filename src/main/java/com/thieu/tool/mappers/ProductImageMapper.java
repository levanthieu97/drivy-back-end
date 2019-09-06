package com.thieu.tool.mappers;

import com.thieu.tool.models.ProductImage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ProductImageMapper {

    int addImageForProduct(@Param("list")List<ProductImage> item);

}
