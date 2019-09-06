package com.thieu.tool.mappers;

import com.thieu.tool.models.PaymentSupplier;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface PaymentSupplierMapper {
    int addPaymentSupplier(@Param("list") List<PaymentSupplier> item);

}
