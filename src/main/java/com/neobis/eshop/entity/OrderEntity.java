package com.neobis.eshop.entity;

import com.neobis.eshop.entity.enums.Status;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;



@Entity
@Table(name = "orders")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Integer id;

    @Column(name = "total")
    private BigDecimal total;

    @Column(name = "order_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date orderDate;

    @Column(name = "delivery_address",length = 1000)
    private String address;

    @Enumerated(EnumType.STRING)
    @Column(name =  "status")
    private Status status;

    @Column(name = "user_email",nullable = false, updatable = false)
    private String userEmail;

    @Column(name = "order_items")
    @OneToMany(cascade = CascadeType.MERGE)
    private List<ProductEntity> orderItems;

    public OrderEntity() {}

    public OrderEntity(BigDecimal total, Date orderDate, String address, Status status, String userEmail, List<ProductEntity> orderItems) {
        this.total = total;
        this.orderDate = orderDate;
        this.address = address;
        this.status = status;
        this.userEmail = userEmail;
        this.orderItems = orderItems;
    }

    public OrderEntity(Status status, String address , List<ProductEntity> orderItems) {
        this.status = status;
        this.address = address;
        this.orderItems = orderItems;
    }

    public OrderEntity(String address , List<ProductEntity> orderItems) {
        this.address = address;
        this.orderItems = orderItems;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<ProductEntity> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<ProductEntity> orderItems) {
        this.orderItems = orderItems;
    }

    @Override
    public String toString() {
        return "OrderEntity{" +
                "id=" + id +
                ", total=" + total +
                ", orderDate=" + orderDate +
                ", address='" + address + '\'' +
                ", status=" + status +
                ", userEmail=" + userEmail +
                ", orderItems=" + orderItems +
                '}';
    }
}
