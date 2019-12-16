package com.neobis.eshop.entity;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "category")
public class CategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Integer id;

    @Column(name = "name", length = 255)
    private String name;

    @Column(name = "image", length = 10000)
    private String image;

    @Column(name = "is_active")
    private boolean isActive;


    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id", referencedColumnName = "category_id")
    private List<SubCategoryEntity> subCategories;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id", referencedColumnName = "category_id")
    private List<TagEntity> tags;

    public CategoryEntity() {
    }

    public CategoryEntity(String name, String image, boolean isActive, List<SubCategoryEntity> subCategories, List<TagEntity> tags) {
        this.name = name;
        this.image = image;
        this.isActive = isActive;
        this.subCategories = subCategories;
        this.tags = tags;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public List<SubCategoryEntity> getSubCategories() {
        return subCategories;
    }

    public void setSubCategories(List<SubCategoryEntity> subCategories) {
        this.subCategories = subCategories;
    }

    public List<TagEntity> getTags() {
        return tags;
    }

    public void setTags(List<TagEntity> tags) {
        this.tags = tags;
    }
}



