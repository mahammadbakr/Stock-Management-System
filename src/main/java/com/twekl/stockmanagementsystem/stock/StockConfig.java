package com.twekl.stockmanagementsystem.stock;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.List;

@Configuration
public class StockConfig {
    @Bean
    CommandLineRunner commandLineRunner(StockRepository stockRepository){
        return args -> {
            Stock erbilStock =new Stock("Erbil Stock","Erbil",20,5,"232eRRR","Category");
            Stock qaladzeStock =new Stock("Qaladze Stock","Qaladze",20,5,"23e2ReRR","Category");

            stockRepository.saveAll(List.of(erbilStock,qaladzeStock));
        };
    }
}
