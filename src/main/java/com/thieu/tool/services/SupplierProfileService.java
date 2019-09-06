package com.thieu.tool.services;

import com.thieu.tool.mappers.SupplierProfileMapper;
import com.thieu.tool.models.SupplierProfile;
import com.thieu.tool.shared.CommonStrings;
import com.thieu.tool.shared.ResponseObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SupplierProfileService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SupplierProfileService.class);


    @Autowired
    private SupplierProfileMapper supplierProfileMapper;

    public ResponseObject createSupplier(SupplierProfile supplierProfile) {
        ResponseObject responseObject = new ResponseObject();
        try {
            int result = supplierProfileMapper.createSupplier(supplierProfile);
            if (result > 0) {
                responseObject.setSuccess(true);
                responseObject.setMessage(CommonStrings.RESP_MSG_SUCCESS);
            } else {
                responseObject.setSuccess(false);
                responseObject.setMessage(CommonStrings.RESP_MSG_SERVER_ERROR);
            }
        } catch (Exception e) {
            LOGGER.error("Error when call registerUser in UserService class: .", e);
            return ResponseObject.FAILURE;

        }
        return responseObject;
    }

    public SupplierProfile isSupplier(int userId) {
        SupplierProfile supplier = supplierProfileMapper.isSupplier(userId);
        if (supplier != null) {
            return supplier;
        }
        return null;
    }

    public SupplierProfile getListProduct(int supplierProfileId) {
        SupplierProfile service = supplierProfileMapper.listProductActiveOfUser(supplierProfileId);
        if (service != null) {
            return service;
        } else {
            return null;
        }
    }

    public SupplierProfile getListProductDetail(int supplierProfileId) {
        SupplierProfile service = supplierProfileMapper.listProductDetailActive(supplierProfileId);
        if (service != null) {
            return service;
        } else {
            return null;
        }
    }

    public SupplierProfile getProductNoActive(int supplierProfileId) {
        SupplierProfile service = supplierProfileMapper.listProductNoActive(supplierProfileId);
        if (service != null) {
            return service;
        } else {
            return null;
        }
    }

    public SupplierProfile getProductDetailNoActive(int supplierProfileId) {
        SupplierProfile service = supplierProfileMapper.listProductDetailNoActive(supplierProfileId);
        if (service != null) {
            return service;
        } else {
            return null;
        }
    }

    public int countProductQuantity(int supplierProfileId) {
        int result = supplierProfileMapper.countProduct(supplierProfileId);
        if (result > 0) {
            return result;
        } else {
            return 0;
        }
    }


}
