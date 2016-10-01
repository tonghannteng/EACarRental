package mum.cs544.project.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Branch {
	@Id
	@GeneratedValue
	int id;

	String brachName;
	@OneToOne
	@JoinColumn(name = "addressId")
	Address address;

	public Branch() {

	}

	public Branch(String brachName, Address address) {
		super();
		this.brachName = brachName;
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBrachName() {
		return brachName;
	}

	public void setBrachName(String brachName) {
		this.brachName = brachName;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

}
