package com.model.lab.controller;

import com.model.lab.entity.Product;
import com.model.lab.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public Page<Product> getProducts(
            @RequestParam Long companyId,
            @RequestParam Long categoryId,
            @RequestParam BigDecimal minPrice,
            @RequestParam BigDecimal maxPrice,
            @RequestParam int page
    ) {
        int size = 10; 
        return productService.getProductsByCategoryAndCompanyAndPriceRange(companyId, categoryId, minPrice, maxPrice, page, size);
    }
}
