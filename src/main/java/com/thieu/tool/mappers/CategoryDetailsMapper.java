package com.thieu.tool.mappers;

import com.thieu.tool.models.CategoryDetails;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CategoryDetailsMapper {
    List<CategoryDetails> suggestCatalog(@Param("cateDetailsType") String cateDetailsType);

    List<CategoryDetails> suggestSupplier(@Param("cateDetailsType") String cateDetailsType);

}
