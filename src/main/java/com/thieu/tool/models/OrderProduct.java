package com.thieu.tool.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@ToString
@NoArgsConstructor
public class OrderProduct {

    private int orderItemId;

    private int orderId;

    private int productId;

    private int productDetailId;

    private int supplierProfileId;

    private String storeName;

    private int productQuantity;

    private int countProduct;

    public OrderProduct(int orderId, int productId, int productDetailId, int supplierProfileId, String storeName, int productQuantity) {
        this.orderId = orderId;
        this.productId = productId;
        this.productDetailId = productDetailId;
        this.supplierProfileId = supplierProfileId;
        this.storeName = storeName;
        this.productQuantity = productQuantity;
    }
}
