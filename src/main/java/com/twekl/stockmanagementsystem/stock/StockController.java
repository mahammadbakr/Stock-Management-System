package com.twekl.stockmanagementsystem.stock;

import com.twekl.stockmanagementsystem.item.Item;
import com.twekl.stockmanagementsystem.item.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    }
    @DeleteMapping(path = "/deleteStock/{stockId}")
    public void deleteStock(@PathVariable("stockId") Long stockId){
        stockServices.deleteStockById(stockId);
    }

    @PutMapping(path = "/updateStock/{stockId}")
    public void updateStock(
            @PathVariable("stockId") Long stockId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String address,
            @RequestParam(required = false) Long size
            ){
        stockServices.updateStock(stockId,name,address,size);
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
