package com.thieu.tool.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class Address {
    private int addressId;
    private String fullName;
    private String phone;
    private String typeAddress;
    private String address;
    private int cityId;
    private int userId;
    private int paymentId;
}
