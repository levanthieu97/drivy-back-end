package com.thieu.tool.models;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

@Data
@ToString
@NoArgsConstructor
public class CatalogType {

    private int catalogTypeId;

    private String typeName;

    private String status;

    private int catalogId;

    private String catalogName;

    private Set<Catalog> catalogs = new HashSet<>();
}
