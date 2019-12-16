package com.neobis.eshop.service;

import com.neobis.eshop.entity.SubCategoryEntity;
import com.neobis.eshop.repository.SubCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubCategoryService {
    @Autowired
    private SubCategoryRepository subcategoryRepository;

    public SubCategoryEntity findById(Integer id) throws Exception {
        return subcategoryRepository.findById(id).orElseThrow(Exception::new);
    }

    public String deleteById(Integer id) {
        subcategoryRepository.deleteById(id);
        return "SubCategory number " + id + " has been deleted!";
    }

    public SubCategoryEntity changeById(Integer id,SubCategoryEntity subcategoryEntity) throws Exception {
        return subcategoryRepository.findById(id)
                .map(subcategory-> {
                    subcategory.setName(subcategoryEntity.getName());
                    subcategory.setActive(subcategoryEntity.isActive());
                    subcategory.setDescription(subcategoryEntity.getDescription());
                    subcategory.setCategoryId(subcategoryEntity.getCategoryId());
                    subcategory.setImage(subcategoryEntity.getImage());
                    return subcategoryRepository.save(subcategory);
                }).orElseThrow( Exception::new);
    }

    public SubCategoryEntity createSubCategory(SubCategoryEntity subcategoryEntity)  {
        return subcategoryRepository.save(subcategoryEntity);
    }

    public List<SubCategoryEntity> getAll(){
        return subcategoryRepository.findAll();
    }

}
