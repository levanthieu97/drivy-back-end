package com.thieu.tool.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class ProductCatalog {
    private int productCatalogId;

    private int productId;

    private int catalogId;

    private Products products;

    private Catalog catalog;
}
