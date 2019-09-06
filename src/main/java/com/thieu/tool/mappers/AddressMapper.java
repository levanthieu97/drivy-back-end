package com.thieu.tool.mappers;

import com.thieu.tool.models.Address;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface AddressMapper {
    int createAddress(Address address);
}
