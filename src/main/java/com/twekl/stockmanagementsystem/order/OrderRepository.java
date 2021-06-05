package com.twekl.stockmanagementsystem.order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {

    //Find an Order by it is Id
    @Query("SELECT s FROM Order s WHERE s.id = ?1")
    Optional<Order> findStockById(String name);

}
