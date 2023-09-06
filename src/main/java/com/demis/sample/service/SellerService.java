package com.demis.sample.service;

import com.demis.sample.dtos.seller.CreatSellerRequest;
import com.demis.sample.model.Seller;
import com.demis.sample.repository.SellerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SellerService {

    private static SellerRepository sellerRepository;

     public void creatSeller(CreatSellerRequest creatSellerRequest){
         sellerRepository.save(CreatSellerRequest.fromDto(creatSellerRequest));
     }

    public List<Seller> getAllSeller(){
        return new ArrayList<>(sellerRepository.findAll()) ;
    }

}
