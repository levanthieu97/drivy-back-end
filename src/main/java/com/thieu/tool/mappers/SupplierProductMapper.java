package com.thieu.tool.mappers;

import com.thieu.tool.models.SupplierProduct;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface SupplierProductMapper {

    int createSupplierProduct(SupplierProduct supplierProduct);

    SupplierProduct checkExistSupplierBuy(SupplierProduct supplierProduct);

    int addProductForSupplier(SupplierProduct supplierProduct);
}
