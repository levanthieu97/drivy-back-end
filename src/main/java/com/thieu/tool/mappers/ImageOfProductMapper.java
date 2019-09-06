package com.thieu.tool.mappers;

import com.thieu.tool.models.ImageOfProduct;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ImageOfProductMapper {
    ImageOfProduct getImageProduct(@Param("productName") String productName);
}
