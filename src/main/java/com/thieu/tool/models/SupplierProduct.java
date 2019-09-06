package com.thieu.tool.models;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class SupplierProduct {
    private int supplierProductId;

    private int productId;

    private int supplierProfileId;

    private String storeName;

    private String productPrice;

    private String productDetailId;

    private String status;

    private int isActive;

    private int count;

    public SupplierProduct(int productId, int supplierProfileId, String status) {
        this.productId = productId;
        this.supplierProfileId = supplierProfileId;
        this.status = status;
    }
}
