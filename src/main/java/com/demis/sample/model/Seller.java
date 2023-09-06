package com.demis.sample.model;

import com.demis.sample.dtos.seller.CreatSellerRequest;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Seller extends Person {

    @Column(nullable = false)
    private String storeName;



    @Override
    public String toString() {
        return """
                Profile:{
                    id= %d ,
                    nationalCode= %s ,
                    firstname = %s ,
                    lastname = %s ,
                    storeName=%s,
                    
                }
                """.formatted(getId(),getNationalCode(), getFirstName(), getLastName(),getStoreName());
    }

    @Override
    public boolean equals(Object object) {
        if (object == null | this.getClass() != object.getClass()) {
            return false;
        }
        if (this.getNationalCode() != null) {
            Seller seller = (Seller) object;
            return this.getNationalCode().equals(seller.getNationalCode());
        } else {
            return false;
        }
    }


}
