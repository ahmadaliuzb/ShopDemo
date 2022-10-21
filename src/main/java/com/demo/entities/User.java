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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User implements java.io.Serializable {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "username", nullable = false, length = 250)
    private String username;

    @Column(name = "password", nullable = false, length = 250)
    private String password;

    @Column(name = "fullname", nullable = false, length = 250)
    private String fullname;

    @Column(name = "email", nullable = false, length = 250)
    private String email;

    @Column(name = "phone", nullable = false, length = 12)
    private String phone;

    @Column(name = "address", nullable = false, length = 250)
    private String address;

    @Temporal(TemporalType.DATE)
    @Column(name = "created", nullable = false, length = 10)
    private Date created = new Date();

    @Column(name = "status", nullable = false)
    private boolean status = true;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "userByUserIdGet")
    private Set<Contact> contactsForUserIdSend = new HashSet<Contact>(0);

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_role", joinColumns = {
            @JoinColumn(name = "user_id", nullable = false, updatable = false)}, inverseJoinColumns = {
            @JoinColumn(name = "role_id", nullable = false, updatable = false)})
    private Set<Role> roles = new HashSet<Role>(0);

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "user")
    private Store store;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private Set<Orders> orderses = new HashSet<Orders>(0);

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private Set<ProductReview> productReviews = new HashSet<ProductReview>(0);

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "userByUserIdGet")
    private Set<Contact> contactsForUserIdGet = new HashSet<Contact>(0);

    public User() {
    }

    public User(String username, String password, String fullname, String email, String phone, String address,
                Date created, boolean status) {
        this.username = username;
        this.password = password;
        this.fullname = fullname;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.created = created;
        this.status = status;
    }

    public User(String username, String password, String fullname, String email, String phone, String address,
                Date created, boolean status, Set<Contact> contactsForUserIdSend, Set<Role> roles, Store store,
                Set<Orders> orderses, Set<ProductReview> productReviews, Set<Contact> contactsForUserIdGet) {
        this.username = username;
        this.password = password;
        this.fullname = fullname;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.created = created;
        this.status = status;
        this.contactsForUserIdSend = contactsForUserIdSend;
        this.roles = roles;
        this.store = store;
        this.orderses = orderses;
        this.productReviews = productReviews;
        this.contactsForUserIdGet = contactsForUserIdGet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        return userId != null && userId.equals(((User) o).getUserId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }



}
