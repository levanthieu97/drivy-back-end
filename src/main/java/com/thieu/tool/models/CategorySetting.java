package com.thieu.tool.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

@Data
@ToString
@NoArgsConstructor
public class CategorySetting {

    private int cateSettingId;

    private String settingName;

    private String settingType;

    private int isActive;

    private int cateDetailsId;

    private String cateDetailsType;

    private Set<CategoryDetails> categoryDetails = new HashSet<>();

    private Category category;

}
