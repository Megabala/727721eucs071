package com.model.lab.repo;
import com.model.lab.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;

public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("SELECT p FROM Product p WHERE p.category.id = :categoryId AND p.category.company.id = :companyId AND p.price BETWEEN :minPrice AND :maxPrice")
    Page<Product> findProductsByCategoryAndCompanyAndPriceRange(
        @Param("categoryId") Long categoryId,
        @Param("companyId") Long companyId,
        @Param("minPrice") BigDecimal minPrice,
        @Param("maxPrice") BigDecimal maxPrice,
        Pageable pageable
    );
}