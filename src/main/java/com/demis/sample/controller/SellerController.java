package com.demis.sample.controller;

import com.demis.sample.dtos.seller.CreatSellerRequest;
import com.demis.sample.model.Seller;
import com.demis.sample.service.SellerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

@Controller
@RequestMapping("/seller")
@RequiredArgsConstructor
public class SellerController {

    private final SellerService sellerService;

    @PostMapping("/creatSeller")
    public void creatSeller(@RequestBody CreatSellerRequest creatSellerRequest){
        sellerService.creatSeller(creatSellerRequest);
    }

    @GetMapping
    List<Seller>getAllSeller(){return sellerService.getAllSeller();}


}
