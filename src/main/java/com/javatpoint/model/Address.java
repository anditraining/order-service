package com.javatpoint.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class Address implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Column
	private String state;
	
	@Id
	private int pin;
	
	@OneToOne(mappedBy = "address")
	private Product product;
	
	public String getState() {
		return state;
	}
	
	public void setState(String state) {
		if(state == null || state.trim().isEmpty()) {
			throw new IllegalStateException("state is wrong");
		}
		this.state = state;
	}
	
	public int getPin() {
		return pin;
	}
	
	public void setPin(int pin) {
		if(pin <= 0 ) {
			throw new IllegalStateException("pin is wrong");
		}
		this.pin = pin;
	}

}
