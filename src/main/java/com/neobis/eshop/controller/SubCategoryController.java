package com.neobis.eshop.controller;

import com.neobis.eshop.entity.SubCategoryEntity;
import com.neobis.eshop.service.SubCategoryService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/subcategory")
public class SubCategoryController {

    @Autowired
    SubCategoryService subCategoryService;

    @GetMapping("/{id}")
    @ApiOperation(value = "Найти подкатегорию по id")
    public SubCategoryEntity getSubCategory(@PathVariable ("id") Integer id) throws Exception {
        return subCategoryService.findById(id);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Изменить подкатегорию")
    public SubCategoryEntity putSubCategory(@PathVariable ("id") Integer id ,@RequestBody SubCategoryEntity subcategoryEntity) throws Exception {
        return subCategoryService.changeById(id,subcategoryEntity);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ApiOperation(value = "Создать подкатегорию")
    public SubCategoryEntity postSubCategory(@RequestBody SubCategoryEntity subcategoryEntity) throws Exception {
        subCategoryService.createSubCategory(subcategoryEntity);
        return subcategoryEntity;
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Удалить подкатегорию")
    public void deleteSubCategory(@PathVariable ("id") Integer id) {
        subCategoryService.deleteById(id);
    }

    @GetMapping(value="/all")
    @ApiOperation(value = "Получить все подкатегории")
    public List<SubCategoryEntity> getAllCategories() {
        return subCategoryService.getAll();
    }
}