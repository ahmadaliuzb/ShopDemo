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
@Table(name = "product_review")
public class ProductReview implements java.io.Serializable {
	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Integer productRivewId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "product_id", nullable = false)
	private Product product;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

	@Column(name = "rating", nullable = false)
	private int rating;

	@Column(name = "coments", nullable = false, length = 500)
	private String coments;

	@Temporal(TemporalType.DATE)
	@Column(name = "created", nullable = false, length = 10)
	private Date created=new Date();

	public ProductReview() {
	}

	public ProductReview(Product product, User user, int rating, String coments, Date created) {
		this.product = product;
		this.user = user;
		this.rating = rating;
		this.coments = coments;
		this.created = created;
	}


}
