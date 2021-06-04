package com.twekl.stockmanagementsystem.stock;

import javax.persistence.*;

@Entity
@Table
public class Stock {
    @Id
    @SequenceGenerator(
            name = "stock_sequence",
            sequenceName = "stock_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
             strategy = GenerationType.SEQUENCE,
            generator = "stock_sequence"
    )
    private Long id;
    private String name;
    private String address;
    private Long size;

    public Stock() {
    }

    public Stock( String name, String address, Long size) {
        this.name = name;
        this.address = address;
        this.size = size;
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

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }
    
    
}