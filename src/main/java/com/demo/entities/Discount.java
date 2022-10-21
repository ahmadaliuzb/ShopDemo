package com.demo.entities;
// Generated Jan 20, 2022, 8:39:05 PM by Hibernate Tools 5.1.10.Final

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Getter
@Setter
@Entity
@Table(name = "discount")
public class Discount implements java.io.Serializable {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;

    @Column(name = "name", nullable = false, length = 250)
    private String name;

    @Column(name = "discout_percent", nullable = false)
    private int discoutPercent;

    @Temporal(TemporalType.DATE)
    @Column(name = "created", nullable = false, length = 10)
    private Date created = new Date();

    @Column(name = "status", nullable = false)
    private boolean status;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "discount")
    private Set<OrderDetail> orderDetails = new HashSet<OrderDetail>(0);

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "discount")
    private Set<Product> products = new HashSet<Product>(0);

    public Discount() {
    }

    public Discount(String name, int discoutPercent, Date created, boolean status) {
        this.name = name;
        this.discoutPercent = discoutPercent;
        this.created = created;
        this.status = status;
    }

    public Discount(String name, int discoutPercent, Date created, boolean status, Set<OrderDetail> orderDetails,
                    Set<Product> products) {
        this.name = name;
        this.discoutPercent = discoutPercent;
        this.created = created;
        this.status = status;
        this.orderDetails = orderDetails;
        this.products = products;
    }
}
