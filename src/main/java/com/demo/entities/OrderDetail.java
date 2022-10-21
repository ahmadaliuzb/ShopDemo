package com.demo.entities;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "order_detail")
public class OrderDetail implements java.io.Serializable {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer orderDetailId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "discount_id", nullable = false)
    private Discount discount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", nullable = false)
    private Orders orders;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Column(name = "quantity", nullable = false)
    private int quantity;

    @Column(name = "unit_price", nullable = false, precision = 22, scale = 0)
    private double unitPrice;

    @Column(name = "note", nullable = false, length = 500)
    private String note;

    @Column(name = "status", nullable = false)

    private boolean status;

    public OrderDetail() {
    }

    public OrderDetail(Discount discount, Orders orders, Product product, int quantity, double unitPrice, String note,
                       boolean status) {
        this.discount = discount;
        this.orders = orders;
        this.product = product;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.note = note;
        this.status = status;
    }
}
