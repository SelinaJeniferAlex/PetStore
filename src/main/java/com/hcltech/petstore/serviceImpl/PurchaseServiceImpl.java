package com.hcltech.petstore.serviceImpl;

import com.hcltech.petstore.dto.PurchaseDTO;
import com.hcltech.petstore.mapper.EntityDtoMapper;
import com.hcltech.petstore.model.Customer;
import com.hcltech.petstore.model.Pet;
import com.hcltech.petstore.model.Purchase;
import com.hcltech.petstore.repository.CustomerRepository;
import com.hcltech.petstore.repository.PetRepository;
import com.hcltech.petstore.repository.PurchaseRepository;
import com.hcltech.petstore.service.PurchaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PurchaseServiceImpl implements PurchaseService {

    @Autowired
    private final PurchaseRepository purchaseRepository;
    @Autowired
    private final PetRepository petRepository;
    @Autowired
    private final CustomerRepository customerRepository;
    @Autowired
    private final EntityDtoMapper mapper;

    @Override
    public PurchaseDTO purchasePet(Long customerId, Long petId) {
        Customer customer = customerRepository.findById(customerId).orElseThrow();
        Pet pet = petRepository.findById(petId).orElseThrow();

        if (!pet.isAvailable()) throw new RuntimeException("Pet is not available for purchase");

        pet.setAvailable(false);
        petRepository.save(pet);

        Purchase purchase = new Purchase();
        purchase.setCustomer(customer);
        purchase.setPet(pet);
        purchase.setPurchaseDate(LocalDateTime.now());
        purchase.setReturned(false);

        return mapper.toPurchaseDTO(purchaseRepository.save(purchase));
    }

    @Override
    public PurchaseDTO returnPet(Long purchaseId) {
        Purchase purchase = purchaseRepository.findById(purchaseId).orElseThrow();
        if (purchase.isReturned()) throw new RuntimeException("Pet already returned");

        if (purchase.getPurchaseDate().plusDays(7).isBefore(LocalDateTime.now())) {
            throw new RuntimeException("Return period exceeded");
        }

        Pet pet = purchase.getPet();
        pet.setAvailable(true);
        petRepository.save(pet);

        purchase.setReturned(true);
        return mapper.toPurchaseDTO(purchaseRepository.save(purchase));
    }

    @Override
    public List<PurchaseDTO> getAllPurchases() {
        return purchaseRepository.findAll().stream()
                .map(mapper::toPurchaseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public PurchaseDTO getPurchaseById(Long id) {
        return mapper.toPurchaseDTO(purchaseRepository.findById(id).orElseThrow());
    }
}
