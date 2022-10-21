package com.demo.entities;
// Generated Jan 20, 2022, 8:39:05 PM by Hibernate Tools 5.1.10.Final

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import static javax.persistence.GenerationType.IDENTITY;

@Getter
@Setter
@Entity
@Table(name = "store")
public class Store implements java.io.Serializable {
	@Id
	@GeneratedValue(strategy = IDENTITY)
	private int userId;

	@OneToOne(fetch = FetchType.LAZY)
	private User user;

	@Column(name = "name", nullable = false, length = 250)
	private String name;

	@Column(name = "address", nullable = false, length = 250)
	private String address;

	@Temporal(TemporalType.DATE)
	@Column(name = "created", nullable = false, length = 10)
	private Date created=new Date();

	@Column(name = "view", nullable = false)
	private int view;

	@Column(name = "status", nullable = false)
	private boolean status;

	@Column(name = "image", nullable = false, length = 250)
	private String image;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "store_category", joinColumns = {
			@JoinColumn(name = "user_id", nullable = false, updatable = false) }, inverseJoinColumns = {
			@JoinColumn(name = "category_id", nullable = false, updatable = false) })
	private List<Category> categories = new ArrayList<Category>(0);

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "store")
	private Set<Orders> orderses = new HashSet<Orders>(0);

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "store")
	private Set<Product> products = new HashSet<Product>(0);

	public Store() {
	}

	public Store(User user, String name, String address, Date created, int view, boolean status, String image) {
		this.user = user;
		this.name = name;
		this.address = address;
		this.created = created;
		this.view = view;
		this.status = status;
		this.image = image;
	}

	public Store(User user, String name, String address, Date created, int view, boolean status, String image,
			List<Category> categories, Set<Orders> orderses, Set<Product> products) {
		this.user = user;
		this.name = name;
		this.address = address;
		this.created = created;
		this.view = view;
		this.status = status;
		this.image = image;
		this.categories = categories;
		this.orderses = orderses;
		this.products = products;
	}

}
