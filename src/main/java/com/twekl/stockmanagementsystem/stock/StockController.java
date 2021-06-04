package com.twekl.stockmanagementsystem.stock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/stocks")
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
    @PostMapping
    public void addNewStock(@RequestBody Stock stock){
        stockServices.addNewStock(stock);
    }
    @DeleteMapping(path = "{stockId}")
    public void addNewStock(@PathVariable("stockId") Long stockId){
        stockServices.deleteStockById(stockId);
    }
    @PutMapping(path = "{stockId}")
    public void updateStock(
            @PathVariable("stockId") Long stockId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String address
            ){
        stockServices.updateStock(stockId,name,address);
    }
}
