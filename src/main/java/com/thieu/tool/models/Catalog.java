package com.thieu.tool.models;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class Catalog {

    private int catalogId;

    private String catalogName;

    private String status;
}
