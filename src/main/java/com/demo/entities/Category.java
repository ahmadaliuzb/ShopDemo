package com.demo.entities;
// Generated Jan 20, 2022, 8:39:05 PM by Hibernate Tools 5.1.10.Final

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "category")
public class Category implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer categoryId;

    @Column(name = "name", nullable = false, length = 250)
    private String name;

    @Column(name = "status", nullable = false)
    private boolean status;

    @Column(name = "image", nullable = false, length = 250)
    private String image;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "categories")
    private Set<Store> stores = new HashSet<Store>(0);

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
    private Set<Product> products = new HashSet<Product>(0);

    public Category() {
    }

    public Category(String name, boolean status, String image) {
        this.name = name;
        this.status = status;
        this.image = image;
    }

    public Category(String name, boolean status, String image, Set<Store> stores, Set<Product> products) {
        this.name = name;
        this.status = status;
        this.image = image;
        this.stores = stores;
        this.products = products;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Category)) return false;
        return categoryId != null && categoryId.equals(((Category) o).getCategoryId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
