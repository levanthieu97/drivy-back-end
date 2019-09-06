package com.thieu.tool.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@ToString
public class ProductDetail {

    private int productDetailId;

    private byte[] pdImage;

    private int productId;

    private String productName;

    private int quantity;

    private String SKU;

    private String price;

    private String status;

    private int colorId;

    private String colorName;

    private int sizeId;

    private String sizeName;
}
