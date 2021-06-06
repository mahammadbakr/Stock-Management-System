package com.twekl.stockmanagementsystem.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;


@Component
public class OrderServices {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderServices(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> getOrders(){
        return orderRepository.findAll();
    }

    public void deleteOrderById(Long orderId) {
        boolean exists = orderRepository.existsById(orderId);
        if(!exists){
            throw new IllegalStateException("Order with id: "+orderId+" does not exist");
        }
        orderRepository.deleteById(orderId);
    }

    @Transactional
    public void updateOrder(Long orderId, String name, Timestamp orderDate) {
        Order order = orderRepository.findById(orderId).orElseThrow(
                ()-> new IllegalStateException("Order with id: "+orderId+" does not exist"));
        if(name!=null && name.length() >0 && !Objects.equals(order.getName(),name)){
            order.setName(name);
        }
        if(!Objects.equals(order.getOrderDate(),orderDate)){
            order.setOrderDate(orderDate);
        }
        orderRepository.save(order);
    }

}
