package com.demis.sample.controller;

import com.demis.sample.model.OrderItem;
import com.demis.sample.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import java.util.Collection;
import java.util.Optional;

@Controller
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {
    private static OrderRepository orderRepository;

    @GetMapping
    public Collection<OrderItem> getAllOrderByCustomerId(Long id){
       return orderRepository.getAllOrderByCustomerId(id);
    }
}
