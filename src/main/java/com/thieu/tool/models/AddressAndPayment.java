package com.thieu.tool.models;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Data
@ToString
@NoArgsConstructor
public class AddressAndPayment {

    /****** Address *****/
    private int addressId;
    private String fullName;
    private String phone;
    private String typeAddress;
    private String address;
    private int cityId;
    private int userId;


    /****** Payment *****/
    private int paymentId;
    private int paymentNumber;
    private String typePayment;
    private Date createDate;
    private String status;
    private String totalDisplay;
    private int isActive;
    private int orderId;
    private List<Integer> supplierProfileId;
}
