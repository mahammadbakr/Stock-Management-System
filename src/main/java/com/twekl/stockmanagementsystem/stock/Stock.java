package com.twekl.stockmanagementsystem.stock;

import com.sun.istack.NotNull;
import com.twekl.stockmanagementsystem.item.Item;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

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
    @NotNull
    private String name;
    @NotNull
    private String address;
    @NotNull
    private Long size;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name ="stock_item",
            joinColumns = { @JoinColumn(name ="stock_fk") },
            inverseJoinColumns = { @JoinColumn(name = "item_fk") })
    private Set<Item> items=new HashSet<>();



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

    public Set<Item> getItems() {
        return items;
    }

    public void setItems(Set<Item> items) {
        this.items = items;
    }

    public void addItemInStock(Item item) {
        items.add(item);
    }

}