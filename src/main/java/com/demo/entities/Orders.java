package com.demo.entities;
import com.fasterxml.jackson.annotation.JsonBackReference;
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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Getter
@Setter
@Entity
@Table(name = "orders")
public class Orders implements java.io.Serializable {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer orderId;


    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shipper_id", nullable = false)
    private Shippers shippers;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "status_id", nullable = false)
    private Status status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id", nullable = false)
    private Store store;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Temporal(TemporalType.DATE)
    @Column(name = "created", nullable = false, length = 10)
    private Date created = new Date();

    @Temporal(TemporalType.DATE)
    @Column(name = "order_of_start", nullable = false, length = 10)
    private Date orderOfStart;

    @Temporal(TemporalType.DATE)
    @Column(name = "order_of_finish", nullable = false, length = 10)
    private Date orderOfFinish;

    @Column(name = "address", nullable = false, length = 250)
    private String address;

    @Column(name = "payment", nullable = false, length = 250)
    private String payment;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "orders")
    private Set<OrderDetail> orderDetails = new HashSet<OrderDetail>(0);

    public Orders() {
    }

    public Orders(Shippers shippers, Status status, Store store, User user, Date created, Date orderOfStart,
                  Date orderOfFinish, String address, String payment) {
        this.shippers = shippers;
        this.status = status;
        this.store = store;
        this.user = user;
        this.created = created;
        this.orderOfStart = orderOfStart;
        this.orderOfFinish = orderOfFinish;
        this.address = address;
        this.payment = payment;
    }

    public Orders(Shippers shippers, Status status, Store store, User user, Date created, Date orderOfStart,
                  Date orderOfFinish, String address, String payment, Set<OrderDetail> orderDetails) {
        this.shippers = shippers;
        this.status = status;
        this.store = store;
        this.user = user;
        this.created = created;
        this.orderOfStart = orderOfStart;
        this.orderOfFinish = orderOfFinish;
        this.address = address;
        this.payment = payment;
        this.orderDetails = orderDetails;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Orders)) return false;
        return orderId != null && orderId.equals(((Orders) o).getOrderId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
