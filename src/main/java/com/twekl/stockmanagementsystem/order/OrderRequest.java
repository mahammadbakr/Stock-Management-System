package com.twekl.stockmanagementsystem.order;

import com.twekl.stockmanagementsystem.vendor.Vendor;

import javax.persistence.*;

@Entity
@Table
public class OrderRequest {
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
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(referencedColumnName = "id")
    private Vendor vendor;

    public OrderRequest() {
    }

    public OrderRequest(Vendor vendor) {
        this.vendor = vendor;
    }

    public OrderRequest(Long id,Vendor vendor) {
        this.id = id;
        this.vendor = vendor;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Vendor getVendor() {
        return vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }
}
