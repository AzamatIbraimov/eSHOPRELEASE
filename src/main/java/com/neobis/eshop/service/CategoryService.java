package com.neobis.eshop.service;

import com.neobis.eshop.entity.CategoryEntity;
import com.neobis.eshop.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public CategoryEntity findById(Integer id) throws Exception {
        return categoryRepository.findById(id).orElseThrow(Exception::new);
    }

    public String deleteById(Integer id) {
        categoryRepository.deleteById(id);
        return "Category number " + id + " has been deleted!";
    }

    public CategoryEntity changeById(Integer id,CategoryEntity categoryEntity) throws Exception {
        return categoryRepository.findById(id)
                .map(category-> {
                    category.setId(categoryEntity.getId());
                    category.setName(categoryEntity.getName());
                    category.setTags(categoryEntity.getTags());
                    category.setImage(categoryEntity.getImage());
                    category.setActive(categoryEntity.isActive());
                    category.setSubCategories(categoryEntity.getSubCategories());
                    return categoryRepository.save(category);
                }).orElseThrow( Exception::new);
    }

    public CategoryEntity createCategory(CategoryEntity categoryEntity)  {
        return categoryRepository.save(categoryEntity);
    }

    public List<CategoryEntity> getAll(){
        return categoryRepository.findAll();
    }

}
