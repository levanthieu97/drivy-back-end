package com.thieu.tool.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class ProductOrderDetail {
    private int productId;

    private int productDetailId;

    private String productName;

    private byte[] pdImage;

    private String SKU;

    private int price;

    private int productQuantityBuy;

    private int pdPrice;

    private String colorName;

    private String sizeName;

    private int quantity;

    private int isActive;

}
