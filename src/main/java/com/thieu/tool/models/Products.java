package com.thieu.tool.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Data
@ToString
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Products {

    private int productId;

    private String productName;

    private String productDescription;

    private String shortDescription;

    private String productCode;

    private int productQuantity;

    private byte[] productImage;

    private int categoryDetailId;

    private int price;

    private int isActive;

    private int isActiveProduct;

    private Date createDate;

    private String createBy;

    private int discount;

    private int alterPrice;

    private String storeSupplier;

    private int supplierProfileId;

    private String storeName;

    private int cartProductQuantity;

    private int orderItemId;

    private int productQuantityBuy;

    private CategoryDetails categoryDetails;

    private List<ProductDetail> productDetails;

    public Products(String productName, String productDescription, String shortDescription, String productCode, int productQuantity,int categoryDetailId, int price ,int alterPrice,String storeSupplier, int isActiveProduct) {
        this.productName = productName;
        this.productDescription = productDescription;
        this.shortDescription = shortDescription;
        this.productCode = productCode;
        this.productQuantity = productQuantity;
        this.categoryDetailId = categoryDetailId;
        this.price = price;
        this.alterPrice = alterPrice;
        this.storeSupplier = storeSupplier;
        this.isActiveProduct = isActiveProduct;
    }


}
