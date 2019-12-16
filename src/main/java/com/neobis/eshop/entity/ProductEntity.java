package com.neobis.eshop.entity;


import com.neobis.eshop.entity.enums.Color;
import com.neobis.eshop.entity.enums.Size;
import io.swagger.models.auth.In;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "product")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Integer id;

    @Column(name = "name", length = 500)
    private String name;

    @Column(name = "in_stock")
    private boolean inStock;

    @Column(name = "description", length = 1000)
    private String description;

    @Column(name = "rating", columnDefinition = "Integer(11) default '0'")
    private Integer rating = 0;

    @Enumerated(EnumType.STRING)
    @Column(name = "size")
    private Size size;

    @Enumerated(EnumType.STRING)
    @Column(name = "color")
    private Color color;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "category")
    private Integer category;

    @Column(name = "sub_category")
    private Integer subCategory;

    @Column(name = "tag")
    private Integer tag;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id", referencedColumnName = "product_id")
    private List<ImageEntity> images;

    public ProductEntity() {
    }

    public ProductEntity(String name, boolean inStock, String description, Integer rating, Size size, Color color, BigDecimal price, Integer category, Integer subCategory, List<ImageEntity> images, Integer tag) {
        this.name = name;
        this.inStock = inStock;
        this.description = description;
        this.rating = rating;
        this.size = size;
        this.color = color;
        this.price = price;
        this.category = category;
        this.subCategory = subCategory;
        this.images = images;
        this.tag = tag;
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

    public boolean isInStock() {
        return inStock;
    }

    public void setInStock(boolean inStock) {
        this.inStock = inStock;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    public Integer getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(Integer subCategory) {
        this.subCategory = subCategory;
    }

    public Integer getTag() {
        return tag;
    }

    public void setTag(Integer tag) {
        this.tag = tag;
    }

    public List<ImageEntity> getImages() {
        return images;
    }

    public void setImages(List<ImageEntity> images) {
        this.images = images;
    }
}