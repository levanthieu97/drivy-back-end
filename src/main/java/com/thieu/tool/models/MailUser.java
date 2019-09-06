package com.thieu.tool.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class MailUser {

    String userName;

    String userAddress;

    String storeName;
}
