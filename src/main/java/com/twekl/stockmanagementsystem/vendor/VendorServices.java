package com.twekl.stockmanagementsystem.vendor;

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

    public void saveVendor(Vendor vendor){
        vendorRepository.save(vendor);
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

    public Vendor findById(Long vendorId) {
        boolean exists = vendorRepository.existsById(vendorId);
        if(!exists){
            throw new IllegalStateException("Vendor with id: "+vendorId+" does not exist");
        }
        Vendor vendor = vendorRepository.findById(vendorId).get();
       return vendor ;
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

}
