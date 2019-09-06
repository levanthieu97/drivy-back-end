package com.thieu.tool.mappers;

import com.thieu.tool.models.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface PaymentMapper {

    int insertPayment(Payment payment);

    Payment getPaymentById();

    Payment getInfoPayment(@Param("paymentId") int paymentId);

    int updateStatus(@Param("status") String status, @Param("paymentId") int paymentId);

    int countPayment(@Param("supplierProfileId") int supplierProfileId);
}
