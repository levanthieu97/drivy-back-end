package com.thieu.tool.models;

import lombok.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@ToString
@NoArgsConstructor
public class Category {
    private int categoryId;

    private String categoryName;

    private String categoryDescription;

    private String categoryCode;

    private String categoryType;

    private int isActive;


    private Set<CategorySetting> categorySettings = new HashSet<>();
    private Set<CategoryDetails> categoryDetails = new HashSet<>();

//
//    private int settingId;


    public Category(String categoryName, String categoryDescription, String categoryCode, int isActive) {
        this.categoryName = categoryName;
        this.categoryDescription = categoryDescription;
        this.categoryCode = categoryCode;
        this.isActive = isActive;

    }
}
