package com.thieu.tool.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class ProductImage {
    private int productImageId;

    private byte[] picture;

    private int productId;

    private Products products;

}
