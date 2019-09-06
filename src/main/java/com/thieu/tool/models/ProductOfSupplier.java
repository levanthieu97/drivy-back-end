package com.thieu.tool.models;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@ToString
@NoArgsConstructor
public class ProductOfSupplier {

    private int productId;

    private String productName;

    private List<SupplierProduct> supplierProducts;


}
