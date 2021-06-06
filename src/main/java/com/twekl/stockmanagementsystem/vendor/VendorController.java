package com.twekl.stockmanagementsystem.vendor;

import com.twekl.stockmanagementsystem.item.Item;
import com.twekl.stockmanagementsystem.item.ItemRepository;
import com.twekl.stockmanagementsystem.order.Order;
import com.twekl.stockmanagementsystem.order.OrderRepository;
import com.twekl.stockmanagementsystem.stock.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/vendors")
public class VendorController {
    @Autowired
    private final ItemRepository itemRepository;

    @Autowired
    private final OrderRepository orderRepository;

    private final VendorServices vendorServices;

    @Autowired
    public VendorController(ItemRepository itemRepository, OrderRepository orderRepository, VendorServices vendorServices){
        this.itemRepository = itemRepository;
        this.orderRepository = orderRepository;
        this.vendorServices=vendorServices;
    }

    @GetMapping
    public List<Vendor> getVendors(){
        return vendorServices.getVendors();
    }
    @PostMapping
    public void addNewVendor(@RequestBody Vendor vendor){
        vendorServices.addNewVendor(vendor);
        throw new ResponseStatusException(
                HttpStatus.OK, "Vendor Added Successfully"
        );
    }
    @DeleteMapping(path = "/deleteVendor/{vendorId}")
    public void deleteVendor(@PathVariable("vendorId") Long vendorId){
        vendorServices.deleteVendorById(vendorId);
        throw new ResponseStatusException(
                HttpStatus.OK, "Vendor Deleted Successfully"
        );
    }
    @PutMapping(path = "/updateVendor/{vendorId}")
    public void updateVendor(
            @PathVariable("vendorId") Long vendorId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String address
    ){
        vendorServices.updateVendor(vendorId,name,address);
        throw new ResponseStatusException(
                HttpStatus.OK, "Vendor Updated Successfully"
        );
    }

    @PutMapping(path = "/addItem/{vendorId}/items/{itemId}")
    public Vendor addAnItem(
            @PathVariable("vendorId") Long vendorId,
            @PathVariable("itemId") Long itemId
    ){
        Item item = itemRepository.findById(itemId).get();
        Vendor vendor = vendorServices.findById(vendorId);

        vendor.addItemInVendor(item);

        vendorServices.saveVendor(vendor);

        return vendor;
    }

    @PutMapping(path = "/addOrder/{vendorId}/orders/{orderId}")
    public Vendor addAnOrder(
            @PathVariable("orderId") Long orderId,
            @PathVariable("vendorId") Long vendorId
    ){
        Order order = orderRepository.findById(orderId).get();
        Vendor vendor = vendorServices.findById(vendorId);

        vendor.addOrderInVendor(order);

        vendorServices.saveVendor(vendor);
        return vendor;
    }

}
