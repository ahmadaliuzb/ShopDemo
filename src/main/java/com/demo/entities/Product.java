package com.demo.entities;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Getter
@Setter
@Entity
@Table(name = "product")
public class Product implements java.io.Serializable {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer productId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "discount_id", nullable = false)
    private Discount discount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private Store store;

    @Column(name = "name", nullable = false, length = 250)
    private String name;

    @Column(name = "price", nullable = false, precision = 22, scale = 0)
    private double price;

    @Column(name = "brand", nullable = false, length = 250)
    private String brand;

    @Column(name = "made_in", nullable = false, length = 250)
    private String madeIn;

    @Column(name = "quantity", nullable = false)
    private int quantity;

    @Column(name = "unit_on_order", nullable = false)
    private int unitOnOrder;

    @Temporal(TemporalType.DATE)
    @Column(name = "created", nullable = false, length = 10)
    private Date created = new Date();

    @Column(name = "content", nullable = false, length = 2000)
    private String content;

    @Column(name = "address", nullable = false, length = 250)
    private String address;

    @Column(name = "status", nullable = false)
    private boolean status;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
    private List<OrderDetail> orderDetails = new ArrayList<OrderDetail>(0);

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
    private List<ProductReview> productReviews = new ArrayList<ProductReview>(0);

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
    private List<Image> images = new ArrayList<Image>(0);

    public Product() {
    }

    public Product(Category category, Discount discount, Store store, String name, double price, String brand,
                   String madeIn, int quantity, int unitOnOrder, Date created, String content, String address,
                   boolean status) {
        this.category = category;
        this.discount = discount;
        this.store = store;
        this.name = name;
        this.price = price;
        this.brand = brand;
        this.madeIn = madeIn;
        this.quantity = quantity;
        this.unitOnOrder = unitOnOrder;
        this.created = created;
        this.content = content;
        this.address = address;
        this.status = status;
    }

    public Product(Category category, Discount discount, Store store, String name, double price, String brand,
                   String madeIn, int quantity, int unitOnOrder, Date created, String content, String address, boolean status,
                   List<OrderDetail> orderDetails, List<ProductReview> productReviews, List<Image> images) {
        this.category = category;
        this.discount = discount;
        this.store = store;
        this.name = name;
        this.price = price;
        this.brand = brand;
        this.madeIn = madeIn;
        this.quantity = quantity;
        this.unitOnOrder = unitOnOrder;
        this.created = created;
        this.content = content;
        this.address = address;
        this.status = status;
        this.orderDetails = orderDetails;
        this.productReviews = productReviews;
        this.images = images;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        return productId != null && productId.equals(((Product) o).getProductId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
