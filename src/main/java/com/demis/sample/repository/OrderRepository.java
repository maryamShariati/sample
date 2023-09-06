package com.demis.sample.repository;


import com.demis.sample.model.Order;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository {


    @Query(value = "select order From Order order where customer.nationalCode=:nationalCode")
    List<Order>order(@Param("nationalCode") Long nationalCode );
}


