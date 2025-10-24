package com.fitnessCentre.app.restca.Models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@XmlRootElement(name = "payment")
@Entity
public class Payment {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Column(name = "Payment_Date", nullable = true, length = 100)
	private String date;
	
	@Column(name = "Payment_Amount", nullable = true, length = 100)
	private int amount;
	
	public Payment() {
		
	}
	
	public Payment(String date, int amount) {
		this.date = date;
		this.amount = amount;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
	
}
