package com.twekl.stockmanagementsystem.vendor;

import com.twekl.stockmanagementsystem.stock.Stock;
import com.twekl.stockmanagementsystem.stock.StockServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/vendors")
public class VendorController {

    private final VendorServices vendorServices;
    @Autowired
    public VendorController(VendorServices vendorServices){
        this.vendorServices=vendorServices;
    }

    @GetMapping
    public List<Vendor> getVendors(){
        return vendorServices.getVendors();
    }
    @PostMapping
    public void addNewVendor(@RequestBody Vendor vendor){
        vendorServices.addNewVendor(vendor);
    }
    @DeleteMapping(path = "{vendorId}")
    public void addNewVendor(@PathVariable("vendorId") Long vendorId){
        vendorServices.deleteVendorById(vendorId);
    }
    @PutMapping(path = "{vendorId}")
    public void updateVendor(
            @PathVariable("vendorId") Long vendorId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String address
    ){
        vendorServices.updateVendor(vendorId,name,address);
    }
}
