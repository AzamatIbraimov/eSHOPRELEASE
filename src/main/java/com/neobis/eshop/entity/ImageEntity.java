package com.neobis.eshop.entity;

import javax.persistence.*;

@Entity
@Table(name = "image")
public class ImageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( name = "image_id")
    private Integer id;

    @Column(name = "url",length = 1000)
    private String url;

    @Column(name = "product_id")
    private Integer productId;

    public ImageEntity() {
    }

    public ImageEntity(String url, Integer productId) {
        this.url = url;
        this.productId = productId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }
}
