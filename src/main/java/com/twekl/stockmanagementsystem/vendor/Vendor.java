package com.twekl.stockmanagementsystem.vendor;

import com.sun.istack.NotNull;
import com.twekl.stockmanagementsystem.item.Item;
import com.twekl.stockmanagementsystem.order.Order;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

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
    @NotNull
    private String name;
    @NotNull
    private String address;
    @NotNull
    private int phone;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name ="vendor_item",
            joinColumns = { @JoinColumn(name ="vendor_fk") },
            inverseJoinColumns = { @JoinColumn(name = "item_fk") })
    private Set<Item> items=new HashSet<>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name ="vendor_order",
            joinColumns = { @JoinColumn(name ="vendor_fk") },
            inverseJoinColumns = { @JoinColumn(name = "order_fk") })
    private Set<Order> orders=new HashSet<>();

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

    public Set<Item> getItems() {
        return items;
    }

    public void setItems(Set<Item> items) {
        this.items = items;
    }

    public void addItemInVendor(Item item) {
        items.add(item);
    }

    public void addOrderInVendor(Order order) {
        orders.add(order);
    }

//    public List<OrderRequest> getRequests() {
//        return requests;
//    }
//
//    public void setRequests(List<OrderRequest> requests) {
//        this.requests = requests;
//    }
//
//    public void addOrderToVendor(OrderRequest request) {
//        requests.add(request);
//    }
}