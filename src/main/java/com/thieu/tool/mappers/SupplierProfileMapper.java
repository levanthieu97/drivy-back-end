package com.thieu.tool.mappers;

import com.thieu.tool.models.SupplierProfile;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface SupplierProfileMapper {
    int createSupplier(SupplierProfile supplierProfile);

    SupplierProfile isSupplier(@Param("userId") int userId);

    SupplierProfile listProductActiveOfUser(@Param("supplierProfileId") int supplierProfileId);

    SupplierProfile listProductDetailActive(@Param("supplierProfileId") int supplierProfileId);

    SupplierProfile listProductNoActive(@Param("supplierProfileId") int supplierProfileId);

    SupplierProfile listProductDetailNoActive(@Param("supplierProfileId") int supplierProfileId);

    int countProduct(@Param("supplierProfileId") int supplierProfileId);
}
