package com.demis.sample.dtos.product;


import com.demis.sample.model.Category;
import com.demis.sample.model.Image;
import com.demis.sample.model.Product;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;


public record CreatProductRequest(
        @NotNull
        @JsonProperty("name") String name,
        @NotNull
        @JsonProperty("quantity") int quantity,
        @JsonProperty("color") String color,
        @JsonProperty("size") String size,
        @NotNull
        @JsonProperty("creatOn") LocalDateTime creatOn,
        @NotNull
        @JsonProperty("price") BigDecimal price,
        @JsonProperty("image") Image image,
        @NotNull
        @JsonProperty("category") Category category) {


        public static Product fromDto(CreatProductRequest productRequest){
                Product product=new Product();
                product.setName(productRequest.name());
                product.setQuantity(productRequest.quantity());
                product.setColor(productRequest.color());
                product.setSize(productRequest.size());
                product.setCreateOn(productRequest.creatOn());
                product.setPrice(productRequest.price());
                product.setImage(productRequest.image());
                product.setCategory(productRequest.category());
                return product;
        }
}
