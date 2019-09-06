package com.thieu.tool.mappers;


import com.thieu.tool.models.SupplierOrder;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface SupplierOrderMapper {

    List<SupplierOrder> getProductInPayment(@Param("supplierProfileId") int supplierProfileId);

    SupplierOrder listProductOrder(@Param("paymentId") int paymentId,@Param("supplierProfileId") int supplierProfileId);

    SupplierOrder listProductDetailOrder(@Param("paymentId") int paymentId, @Param("supplierProfileId") int supplierProfileId);

}
