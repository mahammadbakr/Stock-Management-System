//package com.twekl.stockmanagementsystem.vendor;
//
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.util.List;
//
//@Configuration
//public class VendorConfig {
//
//    @Bean
//    CommandLineRunner CommandLineRunner(VendorRepository vendorRepository){
//        return args -> {
//            Vendor firstVendor =new Vendor("First Vendor","Erbil",7500000);
//            Vendor secondVendor =new Vendor("Second Vendor","Qaladze",7500000);
//
//            vendorRepository.saveAll(List.of(firstVendor,secondVendor));
//        };
//    }
//}
