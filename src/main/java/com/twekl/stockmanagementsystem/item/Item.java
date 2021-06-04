package com.twekl.stockmanagementsystem.item;

import javax.persistence.*;

@Entity
@Table
public class Item {
    @Id
    @SequenceGenerator(
            name = "Item_sequence",
            sequenceName = "Item_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "Item_sequence"
    )
    private Long id;
    private String name;
    private String code;
    private int price;
    private int quantity;

    public Item(){
    }
    public Item(String name, String code, int price, int quantity) {
        this.name = name;
        this.code = code;
        this.price = price;
        this.quantity = quantity;
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}