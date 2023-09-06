package com.demis.sample.dtos.product;


import com.demis.sample.model.Image;
import com.demis.sample.model.Product;

public record GetProductListResponse(
        String name,
        int quantity,
        Image image,
        String category
) {
    public static GetProductListResponse fromProduct(Product product) {
        return new GetProductListResponse(product.getName(), product.getQuantity()
                , product.getImage(), product.getCategory().getName());
    }

}
