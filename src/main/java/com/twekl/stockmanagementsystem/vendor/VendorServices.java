package com.twekl.stockmanagementsystem.vendor;

import com.twekl.stockmanagementsystem.order.OrderRequest;
import com.twekl.stockmanagementsystem.stock.Stock;
import com.twekl.stockmanagementsystem.stock.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Component
public class VendorServices {
    private final VendorRepository vendorRepository;

    @Autowired
    public VendorServices(VendorRepository vendorRepository) {
        this.vendorRepository = vendorRepository;
    }

    public List<Vendor> getVendors(){
        return vendorRepository.findAll();
    }

    public void addNewVendor(Vendor vendor) {
        Optional<Vendor> optionalVendor= vendorRepository.findVendorByName(vendor.getName());
        if(optionalVendor.isPresent()){
            throw new IllegalStateException("Name Already Taken");
        }
        vendorRepository.save(vendor);
    }

    public void deleteVendorById(Long vendorId) {
        boolean exists = vendorRepository.existsById(vendorId);
        if(!exists){
            throw new IllegalStateException("Vendor with id: "+vendorId+" does not exist");
        }
        vendorRepository.deleteById(vendorId);
    }
    @Transactional
    public void updateVendor(Long vendorId, String name, String address) {
        Vendor vendor = vendorRepository.findById(vendorId).orElseThrow(
                ()-> new IllegalStateException("Vendor with id: "+vendorId+" does not exist"));
        if(name!=null && name.length() >0 && !Objects.equals(vendor.getName(),name)){
            vendor.setName(name);
        }
        if(address!=null && address.length() >0 && !Objects.equals(vendor.getAddress(),address)){
            vendor.setAddress(address);
        }
        vendorRepository.save(vendor);
    }

    @Transactional
    public void addRequestFromVendor(Long vendorId, OrderRequest request) {
        Vendor vendor = vendorRepository.findById(vendorId).orElseThrow(
                ()-> new IllegalStateException("Stock with id: "+vendorId+" does not exist"));

        if(request!=null){
            vendor.addOrderToVendor(request);
        }
    }
}
