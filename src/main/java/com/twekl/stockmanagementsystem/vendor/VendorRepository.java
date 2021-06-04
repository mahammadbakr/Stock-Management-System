package com.twekl.stockmanagementsystem.vendor;

import com.twekl.stockmanagementsystem.item.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VendorRepository extends JpaRepository<Vendor,Long> {
    //Find a vendor by it is Name
    @Query("SELECT v FROM Vendor v WHERE v.name = ?1")
    Optional<Vendor> findVendorByName(String name);
}
