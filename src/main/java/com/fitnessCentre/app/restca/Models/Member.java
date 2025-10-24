package com.fitnessCentre.app.restca.Models;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.persistence.Column;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@XmlRootElement(name = "member")
@Entity
public class Member {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Column(name = "Member_Name", nullable = true, length = 100)
	private String name;
	
	@Column(name = "Member_Age", nullable = true)
	private int age;
	
	@Column(name = "Member_Address", nullable = true, length = 100)
	private String address;
	
	@Column(name = "Fitness_Goal", nullable = true, length = 100)
	private String goal;
	
	  @OneToOne(fetch = FetchType.LAZY, orphanRemoval = true, cascade = { CascadeType.ALL })
	  @JoinColumn(name = "member_id", nullable = false)     // FK on PLANS
	  private Set<Plan> plans = new HashSet<>(); 
	  
	  @OneToMany(fetch = FetchType.LAZY, orphanRemoval = true, cascade = { CascadeType.ALL })
	  @JoinColumn(name = "member_id", nullable = false)     // FK on PAYMENTS
	  private Set<Payment> payments = new HashSet<>(); 

    public Member() {
    	
    }
    
    public Member(String name, int age, String address, String goal, Collection<Plan> plans, Collection<Payment> payments ) {
    	this.name = name;
    	this.age = age;
    	this.address = address;
    	this.goal = goal;
		if (plans != null) this.plans.addAll(plans);
		if (payments != null) this.payments.addAll(payments);


    }

    @XmlElement
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@XmlElement
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@XmlElement
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@XmlElement
	public String getGoal() {
		return goal;
	}

	public void setGoal(String goal) {
		this.goal = goal;
	}

	@XmlElement
	public Set<Plan> getPlans() {
		return plans;
	}

	public void setPlans(Set<Plan> plans) {
		this.plans = plans;
	}

	@XmlElement
	public Set<Payment> getPayments() {
		return payments;
	}

	public void setPayments(Set<Payment> payments) {
		this.payments = payments;
	}
    
}
