package com.demis.sample.repository;

import com.demis.sample.model.OrderItem;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface OrderRepository {
    @Query(value = "from OrderItem where customer.id =:id")
    Collection<OrderItem> getAllOrderByCustomerId(@Param("id") Long id);



}


