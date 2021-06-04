package com.twekl.stockmanagementsystem.stock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/getStocks")
public class StockController {

    private final StockServices stockServices;
    @Autowired
    public StockController(StockServices stockServices){
        this.stockServices=stockServices;
    }
    @GetMapping
    public List<Stock> getStocks(){
        return stockServices.getStocks();
    }

}
