package com.neobis.eshop.service;

import com.neobis.eshop.entity.OrderEntity;
import com.neobis.eshop.entity.ProductEntity;
import com.neobis.eshop.entity.enums.Status;
import com.neobis.eshop.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Date;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public OrderEntity findById(Integer id) throws Exception {
        return orderRepository.findById(id).orElseThrow(Exception::new);
    }

    public String deleteById(Integer id) {
        orderRepository.deleteById(id);
        return "Order number " + id + " has been deleted!";
    }

    public OrderEntity changeById(Integer id, OrderEntity orderEntity) throws Exception {
        return orderRepository.findById(id)
                .map(order-> {
                    order.setId(orderEntity.getId());
                    order.setTotal(calculatePrice(orderEntity));
                    order.setOrderDate(orderEntity.getOrderDate());
                    order.setUserEmail(orderEntity.getUserEmail());
                    order.setAddress(orderEntity.getAddress());
                    order.setStatus(orderEntity.getStatus());
                    order.setOrderItems(orderEntity.getOrderItems());
                    return orderRepository.save(order);
                }).orElseThrow( Exception::new);
    }

    public OrderEntity createOrder(OrderEntity orderEntity)  {
        orderEntity.setTotal(calculatePrice(orderEntity));
        orderEntity.setStatus(Status.NEW);
        orderEntity.setOrderDate(Date.from(Instant.now()));
        try {
            Mail.SendEmail((orderEntity.getUserEmail()), "Order Made!", orderEntity.toString()+"\n Your tracking number : 880535535");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return orderRepository.save(orderEntity);
    }

    public List<OrderEntity> getAll(){
        return orderRepository.findAll();
    }

    public List<OrderEntity> getByUser(String mail){
        return orderRepository.findOrderEntitiesByUserEmail(mail);
    }


    public BigDecimal calculatePrice(OrderEntity orderEntity){
        BigDecimal total = BigDecimal.valueOf(0.0);
        for (ProductEntity product : orderEntity.getOrderItems()) {
            product.setInStock(false);
            total = total.add(product.getPrice());
            orderEntity.setTotal(total);
        }
        return total;
    }

}