package com.twekl.stockmanagementsystem.vendor;

import javax.persistence.*;

@Entity
@Table
public class Vendor {
    @Id
    @SequenceGenerator(
            name = "Vendor_sequence",
            sequenceName = "Vendor_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "Vendor_sequence"
    )
    private Long id;
    private String name;
    private String address;
    private int phone;

    public Vendor(){
    }

    public Vendor(String name, String address, int phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }
}