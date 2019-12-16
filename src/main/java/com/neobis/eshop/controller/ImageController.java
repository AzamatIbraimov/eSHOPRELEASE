package com.neobis.eshop.controller;

import com.neobis.eshop.entity.ImageEntity;
import com.neobis.eshop.repository.ImageRepository;
import com.neobis.eshop.service.ImageService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/image")
public class ImageController {

    @Autowired
    ImageService imageService;


    @GetMapping("/{id}")
    @ApiOperation(value = "Найти картинку по id")
    public ImageEntity getImage(@PathVariable ("id") Integer id) throws Exception {
        return imageService.findById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ApiOperation(value = "Создать картинку")
    public ImageEntity postImage(@RequestBody ImageEntity imageEntity) throws Exception {
        imageService.createImage(imageEntity);
        return imageEntity;
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Изменить картинку")
    public ImageEntity putImage(@PathVariable ("id") Integer id ,@RequestBody ImageEntity imageEntity) throws Exception {
    return imageService.changeById(id,imageEntity);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Удалить картинку")
    public void deleteCategory(@PathVariable ("id") Integer id) {
        imageService.deleteById(id);
    }

    @GetMapping(value="/all")
    @ApiOperation(value = "Получить все картинки")
    public List<ImageEntity> getAllCategories() {
        return imageService.getAll();
    }
}