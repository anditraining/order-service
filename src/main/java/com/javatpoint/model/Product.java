package com.javatpoint.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column
	private int id;

	@Column
	private String item;

	@Column
	private float price;

	@OneToOne(cascade = CascadeType.ALL)
	private Address address;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		if (price <= 0) {
			throw new IllegalStateException("price is wrong");
		}
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [productId=" + id + ", name=" + item + ", price=" + price + ", address=" + address.toString()
				+ "]";
	}

}
