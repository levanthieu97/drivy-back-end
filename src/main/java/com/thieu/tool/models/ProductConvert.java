package com.thieu.tool.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@ToString
@NoArgsConstructor
public class ProductConvert {
    private int productId;

    private String productName;

    private String productDescription;

    private String shortDescription;

    private String productCode;

    private int categoryDetailId;

    private int productQuantity;

    private String productImage;

    private int price;

    private String createBy;

    private int discount;

    private int alterPrice;

    private String storeSupplier;

    private List<String> path;

    private List<Integer> pdCatalog;

    private int supplierProduct;

    private List<ProductDetail> productDetail;

    private List<String> imageDetail;

    private int isActiveProduct;
}
