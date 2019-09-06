package com.thieu.tool.controller;

import com.thieu.tool.models.Address;
import com.thieu.tool.models.AddressAndPayment;
import com.thieu.tool.models.City;
import com.thieu.tool.services.AddressService;
import com.thieu.tool.services.CityService;
import com.thieu.tool.shared.ResponseObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/address/")
public class AddressController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AddressController.class);

    @Autowired
    private AddressService service;

    @Autowired
    private CityService cityService;

    @PostMapping("add-address")
    public ResponseObject createAddress(@RequestBody AddressAndPayment addressAndPayment){
        ResponseObject responseObject = new ResponseObject();
        try{
            int result = service.createAddressForUser(addressAndPayment);
            if(result > 0){
                responseObject.setData(result);
                responseObject.setSuccess(true);
                responseObject.setMessage("Successfully !!!");
            }else{
                responseObject.setSuccess(false);
                responseObject.setMessage("Fail !!!");
            }
            return responseObject;
        }catch (Exception e){
            LOGGER.error("Error when call createAddress in AddressController class: .", e);
            return responseObject.FAILURE;
        }
    }

    @GetMapping("city")
    public ResponseObject getCityByName(){
        ResponseObject responseObject = new ResponseObject();
        try {
            List<City> listCategory = cityService.getCity();
            if(listCategory != null){
                responseObject.setData(listCategory);
                responseObject.setSuccess(true);
                responseObject.setMessage("message Successfully!");
            }else{
                responseObject.setSuccess(false);
            }
            return responseObject;
        }catch (Exception e){
            LOGGER.error("Error when call getCityByName in AddressController class: .", e);
            return responseObject.FAILURE;
        }
    }

}
