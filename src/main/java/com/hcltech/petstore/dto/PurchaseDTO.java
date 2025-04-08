package com.hcltech.petstore.dto;

import com.hcltech.petstore.model.Customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseDTO {

    private Long purchaseId;

    private CustomerDTO customerDto;

    private PetDTO pet;

    private LocalDateTime purchaseDate;

    private boolean returned;
}
