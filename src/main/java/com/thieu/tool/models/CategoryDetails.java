package com.thieu.tool.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@ToString
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CategoryDetails {

    private int cateDetailsId;

    private String cateDetailsType;

    private String cateDetailsDescription;

    private int isActive;

    private Date createDate;

    private int categoryCatalogId;

    private CategorySetting categorySetting;

    private Set<Products> products = new HashSet<>();

    private Set<CatalogType> catalogTypes = new HashSet<>();

    private Set<SupplierProfile> supplierProfiles = new HashSet<>();
}
