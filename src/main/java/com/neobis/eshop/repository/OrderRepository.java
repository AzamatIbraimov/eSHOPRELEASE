package com.neobis.eshop.repository;

import com.neobis.eshop.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository <OrderEntity, Integer> {
    List <OrderEntity> findOrderEntitiesByUserEmail(String email);
}
