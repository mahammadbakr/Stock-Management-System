package com.twekl.stockmanagementsystem.order;


import com.twekl.stockmanagementsystem.item.ItemRepository;
import com.twekl.stockmanagementsystem.vendor.Vendor;
import com.twekl.stockmanagementsystem.vendor.VendorRepository;
import com.twekl.stockmanagementsystem.vendor.VendorServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "api/v1/orders")
public class OrderController {
    @Autowired
    private VendorServices vendorServices;


    @PutMapping(path = "{vendorId}")
    public void makeAnOrder(
            @PathVariable("vendorId") Long vendorId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String address,
            @RequestParam(required = false) int phone
    ){
        vendorServices.addRequestFromVendor(vendorId,new OrderRequest(new Vendor(name, address,phone)));
    }

}