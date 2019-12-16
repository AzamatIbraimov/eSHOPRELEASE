package com.neobis.eshop.repository;

import com.neobis.eshop.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {
    List<ProductEntity> findByPriceBetween(BigDecimal low, BigDecimal high);
    List<ProductEntity> findByNameContaining(String text);
    List<ProductEntity> findByCategoryEquals(Integer category);
    List<ProductEntity> findBySubCategoryEquals(Integer subcategory);
    List<ProductEntity> findByTagEquals(Integer tag);
}
