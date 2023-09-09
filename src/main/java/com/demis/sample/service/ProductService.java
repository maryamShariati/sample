package com.demis.sample.service;


import com.demis.sample.dtos.product.CreatProductRequest;
import com.demis.sample.exception.RecordNotFoundException;
import com.demis.sample.model.Product;
import com.demis.sample.model.Seller;
import com.demis.sample.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final SellerService sellerService;

    public Product creatProduct(Seller seller,Product product){
        var sellerByNationalCode = sellerService.getSellerByNationalCode(seller.getNationalCode());
        if (sellerByNationalCode.isEmpty()){
            sellerService.creatSeller(seller);
        }
        product.setSeller(seller);
       return productRepository.save(product);
    }
    public List<Product> getProductByCategory(String category) {
        return productRepository.getProductsByCategory(category);
    }
    public Product getDetailProduct(Long productCode) throws RecordNotFoundException {
        return productRepository.getProductByProductCode(productCode).orElseThrow(RecordNotFoundException::new);
    }

    public void updatePriceByProductCode(Long productCode, BigDecimal price, LocalDateTime time)throws RecordNotFoundException{
            Product product = productRepository.getProductByProductCode(productCode).orElseThrow(() -> new RecordNotFoundException());
            product.setPrice(price);
            product.setUpdateOn(time);
            productRepository.save(product);
        }

    public void updateQuantityByProductCode(Long productCode,int quantity, LocalDateTime time)throws RecordNotFoundException{
        Product product = productRepository.getProductByProductCode(productCode).orElseThrow(() -> new RecordNotFoundException());
        product.setQuantity(quantity);
        product.setUpdateOn(time);
        productRepository.save(product);
    }

    public void deleteProductByProductCode(Long productCode)throws RecordNotFoundException{
        Product product = productRepository.getProductByProductCode(productCode).orElseThrow(() -> new RecordNotFoundException());
        product.setDeleted(true);
        productRepository.save(product);
    }

}
