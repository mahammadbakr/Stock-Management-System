package com.twekl.stockmanagementsystem.item;
import com.twekl.stockmanagementsystem.stock.Stock;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ItemConfig {

    @Bean
    CommandLineRunner commandLineRunner(ItemRepository itemRepository){
        return args -> {
            Item firstItem =new Item("First","ABC123",122,15,new Stock("random","random",100));
            Item secondItem =new Item("Second","ABC234",122,12, new  Stock("random","random",100));

            itemRepository.saveAll(List.of(firstItem,secondItem));
        };
    }
}
