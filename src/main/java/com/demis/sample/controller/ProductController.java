package com.demis.sample.controller;


import com.demis.sample.dtos.product.CreatProductRequest;
import com.demis.sample.dtos.product.GetDetailProductResponse;
import com.demis.sample.dtos.product.GetProductListResponse;
import com.demis.sample.exception.RecordNotFoundException;
import com.demis.sample.model.Product;
import com.demis.sample.service.ProductService;
import org.springframework.ui.Model;
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

    @GetMapping("/showProductForm")
    public String showProductForm(Model model) {
        var creatProduct=new CreatProductRequest();
        model.addAttribute("creatProduct",creatProduct);
        return "createProductForm";
    }

    @PostMapping("/creatProduct")
    public String creatProduct( @ModelAttribute("creatProduct") CreatProductRequest creatProduct) {
        var seller = creatProduct.sellerFromDto();
        var product = creatProduct.productFromDto();
        var product1 = productService.creatProduct(seller, product);
        if (product1 != null) {
            return "okResponse";
        }
        return "notOkResponse";
    }
    @GetMapping("/showProductCard")
    public ModelAndView showProduct(ModelAndView model) {
        model.setViewName("productCard");
        return model;
    }

    @GetMapping("/list/{categoryName}")
    public ModelAndView getProductByCategory(@PathVariable String categoryName,ModelAndView model) {
        List<Product> productByCategory = productService.getProductByCategory(categoryName);
        List<GetProductListResponse> list = productByCategory.stream().map(
                GetProductListResponse::fromProduct
        ).toList();

        model.setViewName("productCard");
        model.addObject("list",productByCategory);
        return model;
    }

    @GetMapping("/{id}")
    public GetDetailProductResponse getProductDetail(@PathVariable Long id) throws RecordNotFoundException {
        var product = productService.getDetailProduct(id);
        return GetDetailProductResponse.fromProductDetail(product);
    }

    @PatchMapping("/update/{productCode}/{price}/{updateOn}")
    public void updatePriceByProductCode(@PathVariable Long productCode, @PathVariable BigDecimal price, @PathVariable LocalDateTime updateOn) throws RecordNotFoundException {
        productService.updatePriceByProductCode(productCode, price, updateOn);
    }

    @PatchMapping("/update/{productCode}/{quantity}/{updateOn}")
    public void updateQuantityByProductCode(@PathVariable Long productCode, @PathVariable int quantity, @PathVariable LocalDateTime updateOn) throws RecordNotFoundException {
        productService.updateQuantityByProductCode(productCode, quantity, updateOn);
    }

    @DeleteMapping("/delete/{productCode}")
    public void deleteByProductCode(@PathVariable Long productCode) throws RecordNotFoundException {
        productService.deleteProductByProductCode(productCode);
    }
}
