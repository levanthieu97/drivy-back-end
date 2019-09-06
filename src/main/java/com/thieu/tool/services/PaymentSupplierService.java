package com.thieu.tool.services;

import com.thieu.tool.mappers.PaymentSupplierMapper;
import com.thieu.tool.models.PaymentSupplier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentSupplierService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PaymentSupplierService.class);

    @Autowired
    private PaymentSupplierMapper mapper;

    public int addListPaymentForSupplier(List<PaymentSupplier> element){
        int result = mapper.addPaymentSupplier(element);
        try {
            if(result > 0){
                return result;
            }
        }catch (Exception e) {
            LOGGER.error("Error when call addListPaymentForSupplier in PaymentSupplierService class: .", e);
            return 0;
        }
        return result;
    }

}
