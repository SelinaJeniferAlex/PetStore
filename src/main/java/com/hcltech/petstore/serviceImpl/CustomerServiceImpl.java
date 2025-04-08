package com.hcltech.petstore.serviceImpl;

import com.hcltech.petstore.dto.CustomerDTO;
import com.hcltech.petstore.mapper.EntityDtoMapper;
import com.hcltech.petstore.model.Customer;
import com.hcltech.petstore.repository.CustomerRepository;
import com.hcltech.petstore.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private final CustomerRepository customerRepository;

    @Autowired
    private final EntityDtoMapper mapper;

    @Override
    public CustomerDTO createCustomer(CustomerDTO dto) {
        Customer customer = mapper.toCustomerEntity(dto);
        return mapper.toCustomerDTO(customerRepository.save(customer));
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        return customerRepository.findAll().stream()
                .map(mapper::toCustomerDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CustomerDTO getCustomerById(Long id) {
        return mapper.toCustomerDTO(customerRepository.findById(id).orElseThrow());
    }

    @Override
    public CustomerDTO updateCustomer(Long id, CustomerDTO dto) {
        Customer customer = customerRepository.findById(id).orElseThrow();
        customer.setCustomerName(dto.getCustomerName());
        customer.setCustomerEmail(dto.getCustomerEmail());
        customer.setCustomerPhone(dto.getCustomerPhone());
        return mapper.toCustomerDTO(customerRepository.save(customer));
    }

    @Override
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }
}
