package com.demis.sample.service;

import com.demis.sample.model.OrderItem;
import com.demis.sample.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderService {
    private static OrderRepository orderRepository;



    public Collection<OrderItem> getAllOrder(Long id){
        return orderRepository.getAllOrderByCustomerId(id);

    };
}
