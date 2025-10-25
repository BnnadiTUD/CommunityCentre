package com.fitnessCentre.app.restca.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
	  
	  public Plan() {
		  
	  }
	  
	  public Plan(String type, int cost) {
		  this.type = type;
		  this.cost = cost;
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
	    
}
