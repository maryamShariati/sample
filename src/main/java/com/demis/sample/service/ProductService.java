package com.demis.sample.service;


import com.demis.sample.dtos.product.CreatProductRequest;
import com.demis.sample.exception.RecordNotFoundException;
import com.demis.sample.model.Product;
import com.demis.sample.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public void creatProduct(CreatProductRequest creatProduct){
        productRepository.save(CreatProductRequest.fromDto(creatProduct));

    }
    public List<Product> getProductByCategory(String category) {
        return productRepository.getProductsByCategory(category);
    }
    public Product getDetailProduct(Long id) throws RecordNotFoundException {
        return productRepository.getProductById(id).orElseThrow(RecordNotFoundException::new);
    }

    public void updatePriceById(Long id, BigDecimal price, LocalDateTime time)throws RecordNotFoundException{
            Product product = productRepository.getProductById(id).orElseThrow(() -> new RecordNotFoundException());
            product.setPrice(price);
            product.setUpdateOn(time);
            productRepository.save(product);
        }

    public void updateQuantityById(Long id,int quantity, LocalDateTime time)throws RecordNotFoundException{
        Product product = productRepository.getProductById(id).orElseThrow(() -> new RecordNotFoundException());
        product.setQuantity(quantity);
        product.setUpdateOn(time);
        productRepository.save(product);
    }

    public void deleteProductById(Long id)throws RecordNotFoundException{
        Product product = productRepository.getProductById(id).orElseThrow(() -> new RecordNotFoundException());
        product.setDeleted(true);
        productRepository.save(product);
    }

}
