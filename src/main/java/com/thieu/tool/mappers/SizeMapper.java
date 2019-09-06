package com.thieu.tool.mappers;

import com.thieu.tool.models.Size;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface SizeMapper {
    List<Size> getAllSize();
}
