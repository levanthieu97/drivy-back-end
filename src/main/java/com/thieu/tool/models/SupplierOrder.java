package com.thieu.tool.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Data
@ToString
@NoArgsConstructor
public class SupplierOrder {
    private int paymentId;
    private String typePayment;
    private Date createDate;
    private String status;
    private String nameCustomer;
    private int isActive;
    private int userId;
    private String phone;
    private String typeAddress;
    private String cityName;
    private String address;
    private int orderId;
    private List<Products> products;
    private List<ProductOrderDetail> productOrderDetails;



}
