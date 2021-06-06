package com.twekl.stockmanagementsystem.item;

import com.sun.istack.NotNull;
import com.twekl.stockmanagementsystem.stock.Stock;
import com.twekl.stockmanagementsystem.vendor.Vendor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


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
    @NotNull
    private String name;
    @NotNull
    private String code;
    @NotNull
    private int price ;
    @NotNull
    private int quantity;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "items")
    private Set<Vendor> vendors=new HashSet<>();

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "items")
    private Set<Vendor> stocks=new HashSet<>();

    public Item(){
    }
    public Item(String name, String code, int price, int quantity,Stock stock) {
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