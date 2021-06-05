package com.twekl.stockmanagementsystem.order;


import com.twekl.stockmanagementsystem.vendor.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "api/v1/orders")
public class OrderController {
    @Autowired
    private OrderServices orderServices;

    @Autowired
    private VendorRepository vendorRepository;

    @Autowired
    public OrderController(OrderServices orderServices){
        this.orderServices=orderServices;
    }

    @GetMapping
    public List<Order> getOrders(){
        return orderServices.getOrders();
    }

    @PutMapping(path = "/updateOrder/{orderId}")
    public void updateItem(
            @PathVariable("orderId") Long orderId,
            @RequestParam(required = false) String name
    ){
        orderServices.updateOrder(orderId,name);
    }

}