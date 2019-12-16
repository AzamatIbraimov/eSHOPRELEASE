package com.neobis.eshop.controller;

import com.neobis.eshop.entity.ProductEntity;
import com.neobis.eshop.service.ProductService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/{id}")
    @ApiOperation(value = "Найти продукт по id")
    public ProductEntity getProduct(@PathVariable ("id") Integer id) throws Exception {
        return productService.findById(id);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Изменить продукт")
    public ProductEntity putProduct(@PathVariable ("id") Integer id ,@RequestBody ProductEntity productEntity) throws Exception {
        productService.changeById(id,productEntity);
        return productEntity;
    }

    @RequestMapping(method = RequestMethod.POST)
    @ApiOperation(value = "Создать продукт")
    public ProductEntity postProduct(@RequestBody ProductEntity productEntity) throws Exception {
        productService.createProduct(productEntity);
        return productEntity;
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Удалить продукт")
    public void deleteProduct(@PathVariable ("id") Integer id) {
        productService.deleteById(id);
    }

    @GetMapping(value="/all")
    @ApiOperation(value = "Получить все продукты")
    public List<ProductEntity> getAllProducts() {
        return productService.getAll();
    }


    @GetMapping(value="/allbyrating")
    @ApiOperation(value = "Получить все продукты по рейтингу")
    public List<ProductEntity> getAllProductsByRating() {
        return productService.getAllByRating();
    }


    @GetMapping(value="/price/{low}/{high}")
    @ApiOperation(value = "Поиск по цене")
    public List<ProductEntity> byPrice(@PathVariable (name = "low",required = false) BigDecimal low,
                                       @PathVariable ("high") BigDecimal high){
        if (low == null){ low = BigDecimal.valueOf(0); }

        return productService.getByPrice(low,high);
    }

    @GetMapping(value="/search/{text}")
    @ApiOperation(value = "Поиск по имени")
    public List<ProductEntity> byName(@PathVariable ("text") String text) {
        if(text.equals("")){
            return null;
        }
        else {
            return productService.getByName(text);
        }
    }

    @GetMapping("/category/{id}")
    @ApiOperation(value = "Поиск по категориям(мужское/женское")
    public List<ProductEntity> getByCategory(@PathVariable ("id") Integer id) throws Exception {
        return productService.getByCategory(id);
    }

    @GetMapping("/subcategory/{id}")
    @ApiOperation(value = "Поиск по субкатегориям")
    public List<ProductEntity> getBySubCategory(@PathVariable ("id") Integer id) throws Exception {
        return productService.getBySubcategory(id);
    }

    @GetMapping("/tag/{id}")
    @ApiOperation(value = "Поиск по тэгу")
    public List<ProductEntity> getByTag(@PathVariable ("id") Integer id) throws Exception {
        return productService.getByTag(id);
    }

}
