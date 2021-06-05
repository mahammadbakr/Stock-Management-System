package com.twekl.stockmanagementsystem.order;

import com.sun.istack.NotNull;
import com.twekl.stockmanagementsystem.item.Item;
import com.twekl.stockmanagementsystem.vendor.Vendor;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table()
public class Order {
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

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "orders")
    private Set<Vendor> vendors=new HashSet<>();


    public Order(String name) {
        this.name=name;
    }

    public Order() {
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

    public Set<Vendor> getVendors() {
        return vendors;
    }

    public void setVendors(Set<Vendor> vendors) {
        this.vendors = vendors;
    }
}
