package com.demo.entities;
// Generated Jan 20, 2022, 8:39:05 PM by Hibernate Tools 5.1.10.Final

import com.fasterxml.jackson.annotation.JsonManagedReference;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Shippers generated by hbm2java
 */
@Getter
@Setter
@Entity
@Table(name = "shippers")
public class Shippers implements java.io.Serializable {
	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Integer shipperId;

	@Column(name = "company_name", nullable = false, length = 250)
	private String companyName;

	@Column(name = "cost", nullable = false, precision = 22, scale = 0)
	private double cost;

	@Column(name = "status", nullable = false)
	private int status;

	@JsonManagedReference
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "shippers")
	private Set<Orders> orderses = new HashSet<Orders>(0);

	public Shippers() {
	}

	public Shippers(String companyName, double cost, int status) {
		this.companyName = companyName;
		this.cost = cost;
		this.status = status;
	}

	public Shippers(String companyName, double cost, int status, Set<Orders> orderses) {
		this.companyName = companyName;
		this.cost = cost;
		this.status = status;
		this.orderses = orderses;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Shippers)) return false;
		return shipperId != null && shipperId.equals(((Shippers) o).getShipperId());
	}

	@Override
	public int hashCode() {
		return getClass().hashCode();
	}

}
