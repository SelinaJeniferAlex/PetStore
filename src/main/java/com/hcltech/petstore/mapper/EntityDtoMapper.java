package com.hcltech.petstore.mapper;

import com.hcltech.petstore.dto.*;
import com.hcltech.petstore.model.*;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class EntityDtoMapper {

    public PetDTO toPetDTO(Pet pet) {
        PetDTO dto = new PetDTO();
        dto.setPetId(pet.getPetId());
        dto.setPetName(pet.getPetName());
        dto.setAge(pet.getAge());
        dto.setBreed(pet.getBreed());
        dto.setGender(pet.getGender());
        dto.setPrice(pet.getPrice());
        dto.setAvailable(pet.isAvailable());
        dto.setCategory(toCategoryDTO(pet.getCategory()));
        dto.setTags(pet.getTags().stream().map(this::toTagDTO).collect(Collectors.toSet()));
        return dto;
    }

    public Pet toPetEntity(PetDTO dto) {
        Pet pet = new Pet();
        pet.setPetId(dto.getPetId());
        pet.setPetName(dto.getPetName());
        pet.setAge(dto.getAge());
        pet.setBreed(dto.getBreed());
        pet.setGender(dto.getGender());
        pet.setPrice(dto.getPrice());
        pet.setAvailable(dto.isAvailable());
        return pet;
    }

    public CustomerDTO toCustomerDTO(Customer customer) {
        CustomerDTO dto = new CustomerDTO();
        dto.setCustomerId(customer.getCustomerId());
        dto.setCustomerName(customer.getCustomerName());
        dto.setCustomerEmail(customer.getCustomerEmail());
        dto.setCustomerPhone(customer.getCustomerPhone());
        return dto;
    }

    public Customer toCustomerEntity(CustomerDTO dto) {
        Customer customer = new Customer();
        customer.setCustomerId(dto.getCustomerId());
        customer.setCustomerName(dto.getCustomerName());
        customer.setCustomerEmail(dto.getCustomerEmail());
        customer.setCustomerPhone(dto.getCustomerPhone());
        return customer;
    }

    public PurchaseDTO toPurchaseDTO(Purchase purchase) {
        PurchaseDTO dto = new PurchaseDTO();
        dto.setPurchaseId(purchase.getPurchaseId());
        dto.setPurchaseDate(purchase.getPurchaseDate());
        dto.setReturned(purchase.isReturned());
        dto.setPet(toPetDTO(purchase.getPet()));
        dto.setCustomerDto(toCustomerDTO(purchase.getCustomer()));
        return dto;
    }

    public Purchase toPurchaseEntity(PurchaseDTO dto) {
        Purchase purchase = new Purchase();
        purchase.setPurchaseId(dto.getPurchaseId());
        purchase.setPurchaseDate(dto.getPurchaseDate());
        purchase.setReturned(dto.isReturned());
        return purchase;
    }

    public CategoryDTO toCategoryDTO(Category category) {
        CategoryDTO dto = new CategoryDTO();
        dto.setCategoryId(category.getCategoryId());
        dto.setCategoryName(category.getCategoryName());
        return dto;
    }

    public TagDTO toTagDTO(Tag tag) {
        TagDTO dto = new TagDTO();
        dto.setTagId(tag.getTagId());
        dto.setTagName(tag.getTagName());
        return dto;
    }
}
