package com.raki.AutoCrankBackEnd.Model;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Table
@Entity
public class Shipping {
	@Id
	private String shippingId;
	private String shippingName;
	private String shippingAddress;
	private String shippingPh_no;
	private String shippingCountry;

	public Shipping() {
		// TODO Auto-generated constructor stub
		this.shippingId = "SHIP" + UUID.randomUUID().toString().substring(30).toUpperCase();
	}

	@ManyToOne
	@JoinColumn(name = "userId")
	private User user;

	@OneToOne
	@JoinColumn(name = "orderId")
	private Order order;

	public String getShippingId() {
		return shippingId;
	}

	public void setShippingId(String shippingId) {
		this.shippingId = shippingId;
	}

	public String getShippingName() {
		return shippingName;
	}

	public void setShippingName(String shippingName) {
		this.shippingName = shippingName;
	}

	public String getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public String getShippingPh_no() {
		return shippingPh_no;
	}

	public void setShippingPh_no(String shippingPh_no) {
		this.shippingPh_no = shippingPh_no;
	}

	public String getShippingCountry() {
		return shippingCountry;
	}

	public void setShippingCountry(String shippingCountry) {
		this.shippingCountry = shippingCountry;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

}
