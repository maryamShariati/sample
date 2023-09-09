package com.demis.sample.service;

import com.demis.sample.model.Seller;
import com.demis.sample.repository.SellerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SellerService {

    private static SellerRepository sellerRepository;

     public Seller creatSeller(Seller seller){
         return sellerRepository.save(seller);
     }

     public Optional<Seller> getSellerByNationalCode(String nationalCode){
         return sellerRepository.getSellerByNationalCode(nationalCode);
     }

    public Page<Seller> getAllSeller(Pageable pageable){
        return  sellerRepository.findAll(pageable) ;
    }


}
