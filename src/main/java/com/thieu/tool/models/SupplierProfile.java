package com.thieu.tool.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.thieu.setup.models.User;
import lombok.*;

import java.util.Date;
import java.util.List;

@Data
@ToString
@NoArgsConstructor
public class SupplierProfile {
    private int supplierProfileId;

    private String storeName;

    private String businessCode;

    private byte[] businessLicenseImage;

    private int isLicense;

    private byte[] storeSymbol;

    private String taxCode;

    private Date createDate;

    private int isActive;

    private int userId;

    private int countProduct;

    private User users;

    private List<Products> products;

    private List<ProductOrderDetail> productOrderDetails;

    public SupplierProfile( String storeName,  String businessCode, int isLicense, String taxCode) {
        this.storeName = storeName;
        this.businessCode = businessCode;
        this.isLicense = isLicense;
        this.taxCode = taxCode;
    }
}
