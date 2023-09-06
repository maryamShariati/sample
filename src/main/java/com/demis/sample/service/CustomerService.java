package com.demis.sample.service;


import com.demis.sample.dtos.customer.CreatCustomerRequest;
import com.demis.sample.model.Customer;
import com.demis.sample.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public void creatCustomer(CreatCustomerRequest creatCustomer){
        customerRepository.save(CreatCustomerRequest.fromDto(creatCustomer));
    }

    public List<Customer>getAllCustomer(){
       return new ArrayList<>(customerRepository.findAll()) ;
    }
}
