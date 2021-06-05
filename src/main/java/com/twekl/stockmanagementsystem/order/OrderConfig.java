package com.twekl.stockmanagementsystem.order;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OrderConfig {

    @Bean
    CommandLineRunner commandLineRunner(OrderRepository orderRepository){
        return args -> {
            Order new1Order =new Order("name order1" );
            Order new2Order =new Order("name order2");

            orderRepository.saveAll(List.of(new1Order,new2Order));
        };
    }
}

