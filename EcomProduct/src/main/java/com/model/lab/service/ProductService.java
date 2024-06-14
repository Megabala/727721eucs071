package com.model.lab.service;

import com.model.lab.entity.Product;
import com.model.lab.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    
    public Page<Product> getProductsByCategoryAndCompanyAndPriceRange(Long companyId, Long categoryId, BigDecimal minPrice, BigDecimal maxPrice, int page, int size) {
        return productRepository.findProductsByCategoryAndCompanyAndPriceRange(categoryId, companyId, minPrice, maxPrice, PageRequest.of(page, size));
    }
}
