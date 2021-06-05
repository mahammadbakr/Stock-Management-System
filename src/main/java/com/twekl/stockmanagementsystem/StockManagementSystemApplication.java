package com.twekl.stockmanagementsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class StockManagementSystemApplication {
	public static void main(String[] args) {
		SpringApplication.run(StockManagementSystemApplication.class, args);
	}
}

