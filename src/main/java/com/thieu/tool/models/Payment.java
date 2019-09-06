package com.thieu.tool.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Payment {
    private int paymentId;
    private int paymentNumber;
    private String typePayment;
    private Date createDate;
    private String status;
    private String totalDisplay;
    private int isActive;
    private int userId;
    private int addressId;
    private int orderId;
}
