package com.thieu.tool.services;

import com.thieu.tool.mappers.AddressMapper;
import com.thieu.tool.mappers.PaymentMapper;
import com.thieu.tool.mappers.PaymentSupplierMapper;
import com.thieu.tool.models.Address;
import com.thieu.tool.models.AddressAndPayment;
import com.thieu.tool.models.Payment;
import com.thieu.tool.models.PaymentSupplier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class AddressService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AddressService.class);

    @Autowired
    private AddressMapper mapper;

    @Autowired
    private PaymentMapper paymentMapper;

    @Autowired
    private PaymentSupplierMapper paymentSupplierMapper;

    public int createAddressForUser(AddressAndPayment addressAndPayment){
        try {
            Address address  = new Address();
            address.setFullName(addressAndPayment.getFullName());
            address.setPhone(addressAndPayment.getPhone());
            address.setTypeAddress(addressAndPayment.getTypeAddress());
            address.setAddress(addressAndPayment.getAddress());
            address.setCityId(addressAndPayment.getCityId());
            address.setUserId(addressAndPayment.getUserId());

            int result  = mapper.createAddress(address);

            Payment payment = new Payment();

            payment.setTypePayment(addressAndPayment.getTypePayment());
            payment.setCreateDate(new Date());
            payment.setStatus("Tiếp nhận đơn hàng");
            payment.setTotalDisplay(addressAndPayment.getTotalDisplay());
            payment.setIsActive(0);
            payment.setAddressId(address.getAddressId());
            payment.setUserId(addressAndPayment.getUserId());
            payment.setOrderId(addressAndPayment.getOrderId());

            int paymentResult = paymentMapper.insertPayment(payment);

            List<PaymentSupplier> list = new ArrayList<>();
            for(int i = 0; i < addressAndPayment.getSupplierProfileId().size(); i++){
                PaymentSupplier paymentSupplier = new PaymentSupplier();
                paymentSupplier.setPaymentId(payment.getPaymentId());
                paymentSupplier.setSupplierId(addressAndPayment.getSupplierProfileId().get(i));
                list.add(paymentSupplier);
            }

            int paymentSupplierResult = paymentSupplierMapper.addPaymentSupplier(list);

            return result;

        }catch (Exception e) {
            LOGGER.error("Error when call createAddressForUser in AddressService class: .", e);
            return 0;
        }
    }

}
