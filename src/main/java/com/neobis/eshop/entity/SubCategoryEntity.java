package com.neobis.eshop.entity;

import javax.persistence.*;


@Entity
@Table(name = "sub_category")
public class SubCategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sub_category_id")
    private Integer id;

    @Column(name = "name",length = 500)
    private String name;

    @Column(name = "description",length = 1000)
    private String description;

    @Column(name = "is_active")
    private boolean isActive;

    @Column(name = "category_id",nullable = false, updatable = false)
    private Integer categoryId;

    @Column(name = "category_image",length = 1000)
    private String image;

    public SubCategoryEntity() {
    }

    public SubCategoryEntity(String name, String description, boolean isActive, Integer categoryId, String image) {
        this.name = name;
        this.description = description;
        this.isActive = isActive;
        this.categoryId = categoryId;
        this.image = image;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
