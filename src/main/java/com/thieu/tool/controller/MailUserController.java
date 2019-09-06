package com.thieu.tool.controller;


import com.thieu.tool.models.MailBill;
import com.thieu.tool.models.MailUser;
import com.thieu.tool.services.MailService;
import com.thieu.tool.shared.ResponseObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/mail/")
public class MailUserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MailUserController.class);

    @Autowired
    private MailService mailService;

    @PostMapping("confirm-register")
    public ResponseObject confirmRegister(@RequestBody MailUser mailUser){
        ResponseObject responseObject = new ResponseObject();
        try{
            mailService.sendEmailConfirmRegister(mailUser);
            responseObject.setSuccess(true);
            responseObject.setMessage("Send Confirm Successfully !!");
            return responseObject;
        }catch (MailException e){
            LOGGER.error("Error when call confirmRegister in MailUserController class: .", e);
            return ResponseObject.FAILURE;
        }
    }


    @PostMapping("buy-product")
    public ResponseObject confirmBuyProduct(@RequestBody MailBill mailBill){
        ResponseObject responseObject = new ResponseObject();
        try{
            mailService.senEmailBuyProduct(mailBill);
            responseObject.setSuccess(true);
            responseObject.setMessage("Send Confirm Successfully !!");
            return responseObject;
        }catch (MailException e){
            LOGGER.error("Error when call confirmBuyProduct in MailUserController class: .", e);
            return ResponseObject.FAILURE;
        }
    }


}
