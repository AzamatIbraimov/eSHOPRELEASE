package com.neobis.eshop.controller;

import com.neobis.eshop.entity.OrderEntity;
import com.neobis.eshop.service.OrderService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/{id}")
    @ApiOperation(value = "Найти заказ по id")
    public OrderEntity getOrder(@PathVariable ("id") Integer id) throws Exception {
        return orderService.findById(id);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Изменить заказ")
    public OrderEntity putOrder(@PathVariable ("id") Integer id ,@RequestBody OrderEntity orderEntity) throws Exception {
        orderService.changeById(id,orderEntity);
        return orderEntity;
    }

    @RequestMapping(method = RequestMethod.POST)
    @ApiOperation(value = "Создать заказ")
    public OrderEntity postOrder(@RequestBody OrderEntity orderEntity) throws Exception {
        orderService.createOrder(orderEntity);
        return orderEntity;
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Удалить заказ")
    public void deleteOrder(@PathVariable ("id") Integer id) {
        orderService.deleteById(id);
    }

    @GetMapping(value="/all")
    @ApiOperation(value = "Получить все заказы")
    public List<OrderEntity> getAllOrders() {
        return orderService.getAll();
    }


    @RequestMapping(path =("/user/{email}"), method = RequestMethod.GET)
    @ApiOperation(value = "Получить все заказы юзера")
    public List<OrderEntity> getOrdersByUserId(@PathVariable("email") String email) {
        return orderService.getByUser(email);
    }
}