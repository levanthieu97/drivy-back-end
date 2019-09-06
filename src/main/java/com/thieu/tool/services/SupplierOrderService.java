package com.thieu.tool.services;


import com.thieu.tool.mappers.SupplierOrderMapper;
import com.thieu.tool.models.SupplierOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierOrderService {
    private static final Logger LOGGER = LoggerFactory.getLogger(SupplierOrderService.class);

    @Autowired
    private SupplierOrderMapper mapper;

    public List<SupplierOrder> listProductForSupplier(int supplierProfileId){
        List<SupplierOrder> service = mapper.getProductInPayment(supplierProfileId);
        if(service != null){
            return service;
        }else{
            LOGGER.error("Error when call listProductForSupplier in SupplierOrderService class: .");
            return null;
        }
    }

    public SupplierOrder getListProduct(int paymentId,int supplierProfileId){
        SupplierOrder service = mapper.listProductOrder(paymentId,supplierProfileId);
        if(service != null){
            return service;
        }else{
//            LOGGER.error("Error when call getListProduct in SupplierOrderService class: .");
            return null;
        }
    }

    public SupplierOrder getListProductDetail(int paymentId, int supplierProfileId){
        SupplierOrder service = mapper.listProductDetailOrder(paymentId, supplierProfileId);
        if(service != null){
            return service;
        }else{
//            LOGGER.error("Error when call listProductDetailForSupplier in SupplierOrderService class: .");
            return null;
        }
    }


}
