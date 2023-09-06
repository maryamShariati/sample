package com.demis.sample.dtos.seller;

import com.demis.sample.model.Seller;
import com.fasterxml.jackson.annotation.JsonProperty;

public record CreatSellerRequest(
        @JsonProperty("nationalCode")String nationalCode,
        @JsonProperty("firstName") String firstName,
        @JsonProperty("lastName") String LastName,
        @JsonProperty("storeName") String storeName
) {
    public static Seller fromDto(CreatSellerRequest creatSeller){
        Seller seller=new Seller();
        seller.setNationalCode(creatSeller.nationalCode());
        seller.setFirstName(creatSeller.firstName());
        seller.setLastName(creatSeller.LastName());
        seller.setStoreName(creatSeller.storeName);
        return seller;
    }
}
