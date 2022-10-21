package com.demo.entities;
// Generated Jan 20, 2022, 8:39:05 PM by Hibernate Tools 5.1.10.Final

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Getter
@Setter
@Entity
@Table(name = "image")
public class Image implements java.io.Serializable {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer imageId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Column(name = "name", nullable = false, length = 250)
    private String name;

    @Temporal(TemporalType.DATE)
    @Column(name = "created", nullable = false, length = 10)
    private Date created = new Date();

    public Image() {
    }

    public Image(Product product, String name, Date created) {
        this.product = product;
        this.name = name;
        this.created = created;
    }
}
