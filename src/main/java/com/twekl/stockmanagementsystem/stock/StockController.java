package com.twekl.stockmanagementsystem.stock;

import com.twekl.stockmanagementsystem.item.Item;
import com.twekl.stockmanagementsystem.item.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/stocks")
public class StockController {

    @Autowired
    private final ItemRepository itemRepository;

    private final StockServices stockServices;
    @Autowired
    public StockController(ItemRepository itemRepository, StockServices stockServices){
        this.itemRepository = itemRepository;
        this.stockServices=stockServices;
    }

    @GetMapping
    public List<Stock> getStocks(){
        return stockServices.getStocks();
    }
    @PostMapping
    public void addNewStock(@RequestBody Stock stock){
        stockServices.addNewStock(stock);
        throw new ResponseStatusException(
                HttpStatus.OK, "Stock Added Successfully"
        );
    }
    @DeleteMapping(path = "/deleteStock/{stockId}")
    public void deleteStock(@PathVariable("stockId") Long stockId){
        stockServices.deleteStockById(stockId);
        throw new ResponseStatusException(
                HttpStatus.OK, "Stock Deleted Successfully"
        );
    }

    @PutMapping(path = "/updateStock/{stockId}")
    public void updateStock(
            @PathVariable("stockId") Long stockId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String address,
            @RequestParam(required = false) int size,
            @RequestParam(required = false) int level,
            @RequestParam(required = false) String productCode,
            @RequestParam(required = false) String productCategory,
            @RequestParam(required = false) Timestamp productDate
            ){
        stockServices.updateStock(stockId,name,address,size,level,productCode,productCategory,productDate);
        throw new ResponseStatusException(
                HttpStatus.OK, "Stock Updated Successfully"
        );
    }

    @PutMapping(path = "/addItem/{stockId}/items/{itemId}")
    public Stock addAnItem(
            @PathVariable("stockId") Long stockId,
            @PathVariable("itemId") Long itemId
    ){

        Item item = itemRepository.findById(itemId).get();
        Stock stock = stockServices.findById(stockId);

        stock.addItemInStock(item);

        stockServices.saveStock(stock);

        return stock;
    }
}
