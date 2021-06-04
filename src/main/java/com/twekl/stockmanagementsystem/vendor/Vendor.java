package com.twekl.stockmanagementsystem.vendor;

import com.sun.istack.NotNull;
import com.twekl.stockmanagementsystem.order.OrderRequest;

import javax.persistence.*;
import java.util.List;

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

    @OneToMany(targetEntity = OrderRequest.class,cascade = CascadeType.ALL)
    @JoinColumn(referencedColumnName = "id")
    private List<OrderRequest> requests;

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

    public List<OrderRequest> getRequests() {
        return requests;
    }

    public void setRequests(List<OrderRequest> requests) {
        this.requests = requests;
    }

    public void addOrderToVendor(OrderRequest request) {
        requests.add(request);
    }
}