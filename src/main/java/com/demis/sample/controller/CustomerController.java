package com.demis.sample.controller;

import com.demis.sample.dtos.customer.CreatCustomerRequest;
import com.demis.sample.model.Customer;
import com.demis.sample.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @PostMapping
    public void creatCustomer(@RequestBody CreatCustomerRequest creatCustomerRequest) {
        customerService.creatCustomer(creatCustomerRequest);
    }
    @GetMapping("/getCustomer")
    List<Customer>getAll(){
        return customerService.getAllCustomer();
    }



}
