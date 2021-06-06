package com.twekl.stockmanagementsystem.stock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Component
public class StockServices {
    private final StockRepository stockRepository;

    @Autowired
    public StockServices(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    public void saveStock(Stock stock){
        stockRepository.save(stock);
    }

    public Stock findById(Long stockId) {
        boolean exists = stockRepository.existsById(stockId);
        if(!exists){
            throw new IllegalStateException("Stock with id: "+stockId+" does not exist");
        }
        Stock stock = stockRepository.findById(stockId).get();
        return stock ;
    }

    public List<Stock> getStocks(){
        return stockRepository.findAll();
    }

    public void addNewStock(Stock stock) {
       Optional<Stock> optionalStock= stockRepository.findStockByName(stock.getName());
       if(optionalStock.isPresent()){
           throw new IllegalStateException("Name Already Taken");
       }
        stockRepository.save(stock);
    }

    public void deleteStockById(Long stockId) {
        boolean exists = stockRepository.existsById(stockId);
        if(!exists){
            throw new IllegalStateException("Stock with id: "+stockId+" does not exist");
        }
        stockRepository.deleteById(stockId);
    }
    @Transactional
    public void updateStock(Long stockId, String name, String address, int size, int level, String productCode, String productCategory, Timestamp productDate) {
        Stock stock = stockRepository.findById(stockId).orElseThrow(
                ()-> new IllegalStateException("Stock with id: "+stockId+" does not exist"));
        if(name!=null && name.length() >0 && !Objects.equals(stock.getName(),name)){
            stock.setName(name);
        }
        if(address!=null && address.length() >0 && !Objects.equals(stock.getAddress(),address)){
            stock.setAddress(address);
        }
        if(!Objects.equals(stock.getSize(),size)){
            stock.setSize(size);
        }
        if(!Objects.equals(stock.getLevel(),level)){
            stock.setLevel(level);
        }
        if(productCode!=null && productCode.length() >0 && !Objects.equals(stock.getProductCode(),productCode)){
            stock.setProductCode(productCode);
        }
        if(productCategory!=null && productCategory.length() >0 && !Objects.equals(stock.getProductCategory(),productCategory)){
            stock.setProductCategory(productCategory);
        }
        if(!Objects.equals(stock.getProductDate(),productDate)){
            stock.setProductDate(productDate);
        }
        stockRepository.save(stock);
    }
}
