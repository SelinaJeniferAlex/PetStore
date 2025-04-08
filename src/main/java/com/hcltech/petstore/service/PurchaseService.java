package com.hcltech.petstore.service;

import com.hcltech.petstore.dto.PurchaseDTO;

import java.util.List;

public interface PurchaseService {

    PurchaseDTO purchasePet(Long customerId, Long petId);
    PurchaseDTO returnPet(Long purchaseId);
    List<PurchaseDTO> getAllPurchases();
    PurchaseDTO getPurchaseById(Long id);
}
