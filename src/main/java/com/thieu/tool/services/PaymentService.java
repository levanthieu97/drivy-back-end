package com.thieu.tool.services;

import com.thieu.tool.mappers.PaymentMapper;
import com.thieu.tool.models.Payment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PaymentService.class);

    @Autowired
    private PaymentMapper mapper;



    public Payment getPaymentId(){
        try {
            Payment payment = mapper.getPaymentById();
            if(payment != null){
                return payment;
            }else{
                return new Payment();
            }
        }catch (Exception e){
            LOGGER.error("Error when call getPaymentId in PaymentService class: .", e);
            return null;
        }
    }

    public Payment getInfoPaymentForUser(int paymentId){
        try {
            Payment payment = mapper.getInfoPayment(paymentId);
            if(payment != null){
                return payment;
            }else{
                return new Payment();
            }
        }catch (Exception e){
            LOGGER.error("Error when call getInfoPaymentForUser in PaymentService class: .", e);
            return null;
        }
    }

    public int updateStatusPayment(String status, int paymentId){
        int result = mapper.updateStatus(status,paymentId);
        try {
            if(result > 0){
                return result;
            }
        }catch (Exception e) {
            LOGGER.error("Error when call updateStatusPayment in PaymentService class: .", e);
            return 0;
        }
        return result;
    }

    public int countPaymentQuantity(int supplierProfileId) {
        int result = mapper.countPayment(supplierProfileId);
        if (result > 0) {
            return result;
        } else {
            return 0;
        }
    }
}
