package com.twekl.stockmanagementsystem.item;

import com.twekl.stockmanagementsystem.stock.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ItemRepository  extends JpaRepository<Item,Long> {
    //Find an Item by it is Name
    @Query("SELECT i FROM Item i WHERE i.name = ?1")
    Optional<Item> findItemByName(String name);

}
