package com.thieu.tool.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;


@Data
@ToString
@NoArgsConstructor
public class CategoryCatalog {

    private int categoryCatalogId;

    private int categoryDetailId;

    private int catalogTypeId;

    private String detailType;

    private String typeName;

    private String status;

    private Set<Catalog> catalogs = new HashSet<>();

}
