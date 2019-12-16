package com.neobis.eshop.service;

import com.neobis.eshop.entity.ImageEntity;
import com.neobis.eshop.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageService {
    @Autowired
    private ImageRepository imageRepository;

    public ImageEntity findById(Integer id) throws Exception {
        return imageRepository.findById(id).orElseThrow(Exception::new);
    }

    public String deleteById(Integer id) {
        imageRepository.deleteById(id);
        return "Image number " + id + " has been deleted!";
    }

    public ImageEntity changeById(Integer id,ImageEntity imageEntity) throws Exception {
        return imageRepository.findById(id)
                .map(image-> {
                    image.setId(imageEntity.getId());
                    image.setUrl(imageEntity.getUrl());
                    image.setProductId(imageEntity.getProductId());
                    return imageRepository.save(image);
                }).orElseThrow( Exception::new);
    }

    public ImageEntity createImage(ImageEntity imageEntity)  {
        return imageRepository.save(imageEntity);
    }

    public List<ImageEntity> getAll(){
        return imageRepository.findAll();
    }

}
