package com.demis.sample.controller;

import com.demis.sample.dtos.product.CreatProductRequest;
import com.demis.sample.dtos.product.GetDetailProductResponse;
import com.demis.sample.dtos.product.GetProductListResponse;
import com.demis.sample.exception.RecordNotFoundException;
import com.demis.sample.model.Product;
import com.demis.sample.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping
    public void creatProduct(@RequestBody CreatProductRequest creatProduct){
        productService.creatProduct(creatProduct);
    }

    @GetMapping("/{categoryName}")
    public ModelAndView getProductByCategory(@PathVariable String categoryName){
        List<Product> productByCategory = productService.getProductByCategory(categoryName);
        List<GetProductListResponse> list= productByCategory.stream().map(
                GetProductListResponse::fromProduct
        ).toList();

        return new ModelAndView("seeProductByCategory.jsp","GetProductListResponse",list);
    }

    @GetMapping("/{id}")
    public GetDetailProductResponse getProductDetail(@PathVariable Long id) throws RecordNotFoundException {
       var product= productService.getDetailProduct(id);
       return new GetDetailProductResponse(product.getName(), product.getQuantity(), product.getColor(), product.getPrice(),product.getImage(),product.getCategory().getName());
    }

    @PatchMapping("/update/{id}/{price}/{updateOn}")
    public void updatePriceById(@PathVariable Long id,@PathVariable BigDecimal price,@PathVariable LocalDateTime updateOn) throws RecordNotFoundException {
        productService.updatePriceById(id,price,updateOn);
    }

    @PatchMapping("/update/{id}/{quantity}/{updateOn}")
    public void updateQuantityById(@PathVariable Long id,@PathVariable int quantity,@PathVariable LocalDateTime updateOn) throws RecordNotFoundException {
        productService.updateQuantityById(id, quantity, updateOn);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id) throws RecordNotFoundException {
        productService.deleteProductById(id);
    }


}
