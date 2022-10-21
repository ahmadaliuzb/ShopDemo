package com.demo.entities;

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

@Getter
@Setter
@Entity
@Table(name = "status")
public class Status implements java.io.Serializable {
	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Integer statusId;

	@Column(name = "name", nullable = false, length = 250)
	private String name;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "status")
	private Set<Orders> orderses = new HashSet<Orders>(0);

	public Status() {
	}

	public Status(String name) {
		this.name = name;
	}

	public Status(String name, Set<Orders> orderses) {
		this.name = name;
		this.orderses = orderses;
	}


}
