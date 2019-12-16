package com.neobis.eshop.controller;

import com.neobis.eshop.entity.CategoryEntity;
import com.neobis.eshop.service.CategoryService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping("/{id}")
    @ApiOperation(value = "Найти категорию по id")
    public CategoryEntity getCategory(@PathVariable ("id") Integer id) throws Exception {
        return categoryService.findById(id);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Изменить категорию")
    public CategoryEntity putCategory(@PathVariable ("id") Integer id ,@RequestBody CategoryEntity categoryEntity) throws Exception {
    return categoryService.changeById(id,categoryEntity);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ApiOperation(value = "Создать категорию")
    public CategoryEntity postCategory(@RequestBody CategoryEntity categoryEntity) throws Exception {
        categoryService.createCategory(categoryEntity);
        return categoryEntity;
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Удалить категорию")
    public void deleteCategory(@PathVariable ("id") Integer id)
    {
        categoryService.deleteById(id);
    }

    @GetMapping(value="/all")
    @ApiOperation(value = "Получить все категории")
    public List<CategoryEntity> getAllCategories() {
        return categoryService.getAll();
    }
}