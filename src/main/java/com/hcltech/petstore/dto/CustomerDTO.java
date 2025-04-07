package com.hcltech.petstore.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDTO {

    private Long customerId;

    private String customerName;

    private String customerEmail;

    private String customerPhone;

    private List<PurchaseDTO> purchases;
}
