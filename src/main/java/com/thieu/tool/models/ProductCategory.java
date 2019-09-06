package com.thieu.tool.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class ProductCategory {

    private int productId;

    private String productName;

    private int categoryDetailId;

    private String categoryDetailType;

    private int categorySettingId;

    private String settingName;

    private int categoryId;

    private String categoryName;
}
