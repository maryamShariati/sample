package com.demis.sample.dtos.product;



import com.demis.sample.model.Image;
import com.demis.sample.model.Product;

import java.math.BigDecimal;

public record GetDetailProductResponse(
        String name,
        int quantity,
        String color,
        BigDecimal price,
        Image image,
        String category
) {
    public static GetDetailProductResponse fromProductDetail(Product product) {
        return new GetDetailProductResponse(product.getName(), product.getQuantity(), product.getColor(),
                product.getPrice(), product.getImage(), product.getCategory().getName());
    }

}