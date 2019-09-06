package com.thieu.tool.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@ToString
@NoArgsConstructor
public class Orders {

    private int orderId;

    private int userId;

    private int quantity;

    private String status;

    private int isActive;

    private List<Products> products;

    private List<ProductDetail> productDetails;

    public Orders(int userId, int quantity, String status, int isActive) {
        this.userId = userId;
        this.quantity = quantity;
        this.status = status;
        this.isActive = isActive;
    }
}
