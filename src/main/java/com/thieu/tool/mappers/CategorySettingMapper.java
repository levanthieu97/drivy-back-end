package com.thieu.tool.mappers;

import com.thieu.tool.models.CategorySetting;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CategorySettingMapper {
    List<CategorySetting> getCategorySetting(@Param("categoryId") int categoryId);

    List<CategorySetting> getSettingDetail();

    List<CategorySetting> getNameCateSetting();

    List<CategorySetting> getNameForSettingDetail(@Param("settingName") String settingName);

    CategorySetting getCrumsCategory (@Param("settingName") String settingName);
}
