package com.demis.sample.controller;

import com.demis.sample.dtos.customer.CreatCustomerRequest;
import com.demis.sample.model.Customer;
import com.demis.sample.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;
    @GetMapping("/showCustomerForm")
    public String showProductForm(Model model) {
        var creatCustomer = new CreatCustomerRequest();
        model.addAttribute("customer",creatCustomer);
        return "formCustomer";
    }
    @PostMapping("/creatCustomer")
    public String creatCustomer(@ModelAttribute("customer") CreatCustomerRequest creatCustomerRequest) {
        var customer=creatCustomerRequest.customerFromDto();
        var address=creatCustomerRequest.addressFromDto();
        var customer1 = customerService.creatCustomer(customer,address);
        if (customer1 != null) {
            return "okResponse";
        }
        return "notOkResponse";
    }
    @GetMapping("/getCustomer")
    List<Customer>getAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size
    ){
        Pageable pageable= PageRequest.of(page, size);
        return customerService.getAllCustomer(pageable);
    }
}
