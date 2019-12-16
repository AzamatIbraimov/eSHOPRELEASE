package com.neobis.eshop.service;

import com.neobis.eshop.entity.ProductEntity;
import com.neobis.eshop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public ProductEntity findById(Integer id) throws Exception {
        return productRepository.findById(id).orElseThrow(Exception::new);
    }

    public String deleteById(Integer id) {
        productRepository.deleteById(id);
        return "Product number " + id + " has been deleted!";
    }

    public ProductEntity changeById(Integer id, ProductEntity productEntity) throws Exception {
        return productRepository.findById(id)
                .map(product-> {
                    product.setId(productEntity.getId());
                    product.setInStock(productEntity.isInStock());
                    product.setRating(productEntity.getRating());
                    product.setCategory(productEntity.getCategory());
                    product.setColor(productEntity.getColor());
                    product.setDescription(productEntity.getDescription());
                    product.setImages(productEntity.getImages());
                    product.setSubCategory(productEntity.getSubCategory());
                    product.setName(productEntity.getName());
                    product.setSize(productEntity.getSize());
                    product.setPrice(productEntity.getPrice());
                    return productRepository.save(product);
                }).orElseThrow( Exception::new);
    }

    public ProductEntity createProduct(ProductEntity productEntity)  {
        return productRepository.save(productEntity);
    }

    public List<ProductEntity> getAll(){
        return productRepository.findAll();
    }

    public List<ProductEntity> getAllByRating(){
        return productRepository.findAll(Sort.by(Sort.Direction.DESC,"rating"));
    }

    public List<ProductEntity> getByPrice(BigDecimal low, BigDecimal high){
        return productRepository.findByPriceBetween(low,high);
    }

    public List<ProductEntity> getByName(String text){
        return productRepository.findByNameContaining(text);
    }

    public List<ProductEntity> getByCategory(Integer category){
        return productRepository.findByCategoryEquals(category);
    }
    public List<ProductEntity> getBySubcategory(Integer subcategory){
        return productRepository.findBySubCategoryEquals(subcategory);
    }
    public List<ProductEntity> getByTag(Integer tag){
        return productRepository.findByTagEquals(tag);
    }

}