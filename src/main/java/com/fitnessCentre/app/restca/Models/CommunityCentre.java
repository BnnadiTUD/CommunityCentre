package com.fitnessCentre.app.restca.Models;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
//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 token
import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.persistence.Column;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@XmlRootElement(name = "CommunityCentre")
@Entity
public class CommunityCentre {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Column(name = "Name_of_Community_Centre", nullable = true, length = 100)
	private String name;
	
	@Column(name = "Address_of_Community_Centre", nullable = true, length = 100)
	private String address;
	
	  @OneToMany(fetch = FetchType.LAZY, orphanRemoval = true, cascade = { CascadeType.ALL })
	  @JoinColumn(name = "centre_id", nullable = true)     // FK on MEMBERS
	  private Set<Member> members = new HashSet<>(); 
	  
	  public CommunityCentre() {
		  
	  }
	  
	  public CommunityCentre(String name, String address, Collection<Member> members) {
		  this.name = name;
		  this.address = address;
		  if (members != null) this.members.addAll(members);
	  }

	  @XmlElement
	  public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@XmlElement
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@XmlElement
	public Set<Member> getMembers() {
		return members;
	}

	public void setMembers(Set<Member> members) {
		this.members = members;
	}

}
