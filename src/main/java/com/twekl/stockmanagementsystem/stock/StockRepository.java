package com.twekl.stockmanagementsystem.stock;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StockRepository extends JpaRepository<Stock,Long> {
    @Query("SELECT s FROM Stock s WHERE s.name = ?1")
    Optional<Stock> findStockByName(String name);
}
