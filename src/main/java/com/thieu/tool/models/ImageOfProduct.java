package com.thieu.tool.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

@Data
@ToString
@NoArgsConstructor
public class ImageOfProduct {

    private int productId;

    private String productName;

    private byte[] productImage;

    private Set<ProductImage> productImages = new HashSet<>();
}
