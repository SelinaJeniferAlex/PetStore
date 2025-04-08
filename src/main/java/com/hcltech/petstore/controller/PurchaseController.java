package com.hcltech.petstore.controller;

import com.hcltech.petstore.dto.PurchaseDTO;
import com.hcltech.petstore.service.PurchaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/purchases")
//@RequiredArgsConstructor
public class PurchaseController {

    @Autowired
    private PurchaseService purchaseService;

    @PostMapping("/buy")
    public ResponseEntity<PurchaseDTO> purchasePet(@RequestParam Long customerId, @RequestParam Long petId) {
        return ResponseEntity.ok(purchaseService.purchasePet(customerId, petId));
    }

    @PostMapping("/return/{purchaseId}")
    public ResponseEntity<PurchaseDTO> returnPet(@PathVariable Long purchaseId) {
        return ResponseEntity.ok(purchaseService.returnPet(purchaseId));
    }

    @GetMapping
    public ResponseEntity<List<PurchaseDTO>> getAll() {
        return ResponseEntity.ok(purchaseService.getAllPurchases());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PurchaseDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(purchaseService.getPurchaseById(id));
    }
}
