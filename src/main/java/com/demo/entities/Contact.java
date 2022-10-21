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
@Table(name = "contact")
public class Contact implements java.io.Serializable {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Integer contactId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id_send", nullable = false)
	private User userByUserIdSend;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id_get", nullable = false)
	private User userByUserIdGet;

	@Column(name = "messenger", nullable = false, length = 1000)
	private String messenger;

	@Temporal(TemporalType.DATE)
	@Column(name = "created", nullable = false, length = 10)
	private Date created=new Date();

	public Contact() {
	}

	public Contact(User userByUserIdSend, User userByUserIdGet, String messenger, Date created) {
		this.userByUserIdSend = userByUserIdSend;
		this.userByUserIdGet = userByUserIdGet;
		this.messenger = messenger;
		this.created = created;
	}
}
