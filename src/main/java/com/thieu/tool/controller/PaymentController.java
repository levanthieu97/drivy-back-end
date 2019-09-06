package com.thieu.tool.controller;

import com.thieu.tool.models.Payment;
import com.thieu.tool.models.PaymentSupplier;
import com.thieu.tool.services.PaymentService;
import com.thieu.tool.services.PaymentSupplierService;
import com.thieu.tool.shared.ResponseObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/payment/")
public class PaymentController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PaymentController.class);

    @Autowired
    private PaymentService service;


    @Autowired
    private PaymentSupplierService paymentSupplierService;

    @GetMapping("payment-code")
    public ResponseObject getPaymentById(){
        ResponseObject responseObject = new ResponseObject();
        try{
            Payment payment = service.getPaymentId();
            if(payment != null){
                responseObject.setData(payment);
                responseObject.setSuccess(true);
                responseObject.setMessage("Successfully !!!");
            }else{
                responseObject.setSuccess(false);
                responseObject.setMessage("Failed!!!");
            }
            return responseObject;
        }catch (Exception e){
            LOGGER.error("Error when call getPaymentById in PaymentController class: .", e);
            return ResponseObject.FAILURE;
        }
    }


    @GetMapping("info-payment")
    public ResponseObject getInfoPayment(@RequestParam int paymentId){
        ResponseObject responseObject = new ResponseObject();
        try{
            Payment payment = service.getInfoPaymentForUser(paymentId);
            if(payment != null){
                responseObject.setData(payment);
                responseObject.setSuccess(true);
                responseObject.setMessage("Successfully !!!");
            }else{
                responseObject.setSuccess(false);
                responseObject.setMessage("Failed!!!");
            }
            return responseObject;
        }catch (Exception e){
            LOGGER.error("Error when call getInfoPayment in PaymentController class: .", e);
            return ResponseObject.FAILURE;
        }
    }


    @PostMapping("payment-supplier")
    public ResponseObject addPaymentSupplier(@RequestBody List<PaymentSupplier> elememt){
        ResponseObject responseObject = new ResponseObject();
        try{
            int result = paymentSupplierService.addListPaymentForSupplier(elememt);
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
            LOGGER.error("Error when call updateOrder in OrdersController class: .", e);
            return responseObject.FAILURE;
        }
    }

    @PutMapping("status")
    public ResponseObject updateStatus(@RequestParam String status, @RequestParam int paymentId){
        ResponseObject responseObject = new ResponseObject();
        try{
            int result = service.updateStatusPayment(status,paymentId);
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
            LOGGER.error("Error when call updateStatus in PaymentController class: .", e);
            return responseObject.FAILURE;
        }
    }

    @GetMapping("count-payment")
    public ResponseObject quantityPayment(@RequestParam int supplierProfileId){
        ResponseObject responseObject = new ResponseObject();
        try {
            int result = service.countPaymentQuantity(supplierProfileId);
            if (result >= 0) {
                responseObject.setData(result);
                responseObject.setSuccess(true);
                responseObject.setMessage("Successfully !!!");
            } else {
                responseObject.setSuccess(false);
            }
            return responseObject;
        }catch (Exception e){
            LOGGER.error("Error when call quantityProduct in SupplierController class: .", e);
            return ResponseObject.FAILURE;
        }
    }


}
