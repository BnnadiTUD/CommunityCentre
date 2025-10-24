package com.fitnessCentre.app.restca.Models;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "plan")
@Entity
public class Plan {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Column(name = "Plan_Description", nullable = true, length = 100)
	private String type;
	
	@Column(name = "Plan_Cost", nullable = true, length = 100)
	private int cost;
	  
	  @OneToMany(fetch = FetchType.LAZY, orphanRemoval = true, cascade = { CascadeType.ALL })
	  @JoinColumn(name = "plan_id", nullable = false)     // FK on Payements
	  private Set<Payment> payments = new HashSet<>(); 
	  
	  public Plan() {
		  
	  }
	  
	  public Plan(String type, int cost, Collection<Payment> payments) {
		  this.type = type;
		  this.cost = cost;
		  if (payments != null) this.payments.addAll(payments);
	  }

	  @XmlElement
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@XmlElement
	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	@XmlElement
	public Set<Payment> getPayments() {
		return payments;
	}

	public void setPayments(Set<Payment> payments) {
		this.payments = payments;
	}
	    
}
