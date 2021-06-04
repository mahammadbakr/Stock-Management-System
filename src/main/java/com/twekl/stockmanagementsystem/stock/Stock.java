package com.twekl.stockmanagementsystem.stock;

import com.sun.istack.NotNull;
import com.twekl.stockmanagementsystem.item.Item;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.List;

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
    @OneToMany(targetEntity = Item.class,cascade = CascadeType.ALL)
    @JoinColumn(referencedColumnName = "id")
    private List<Item> items;

    public Stock() {
    }

    public Stock( String name, String address, Long size) {
        this.name = name;
        this.address = address;
        this.size = size;
    }

    public Stock( String name, String address, Long size,List<Item> items) {
        this.name = name;
        this.address = address;
        this.size = size;
        this.items= items;
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

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}