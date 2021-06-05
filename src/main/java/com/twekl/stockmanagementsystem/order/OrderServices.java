package com.twekl.stockmanagementsystem.order;

import com.twekl.stockmanagementsystem.stock.Stock;
import com.twekl.stockmanagementsystem.vendor.Vendor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
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

    @Transactional
    public void updateOrder(Long orderId, String name) {
        Order order = orderRepository.findById(orderId).orElseThrow(
                ()-> new IllegalStateException("Order with id: "+orderId+" does not exist"));
        if(name!=null && name.length() >0 && !Objects.equals(order.getName(),name)){
            order.setName(name);
        }
        orderRepository.save(order);
    }


}
