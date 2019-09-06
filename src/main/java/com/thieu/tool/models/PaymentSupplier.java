package com.thieu.tool.models;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class PaymentSupplier {

    private int paymentSupplierId;

    private int paymentId;

    private int supplierId;
}
