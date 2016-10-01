package mum.cs544.project.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
public class ReturnCar {
	@Id @GeneratedValue
	private int id;
	@OneToOne
	@JoinColumn(name="pickupId")
	private Pickup pickup;
	@Temporal(TemporalType.TIMESTAMP)
	private Date actualPickupDate;
	@ManyToOne
	@JoinColumn(name="addressId")
	private Address address;
	@ManyToOne
	@JoinColumn(name="employeeId")
	private User employee;
	@OneToOne
	@JoinColumn(name = "branchId")
	private Branch branch;

	public ReturnCar() {

	}

	public ReturnCar(Pickup pickup, Date actualPickupDate, Address address, User employee, Branch branch) {
		super();
		this.pickup = pickup;
		this.actualPickupDate = actualPickupDate;
		this.address = address;
		this.employee = employee;
		this.branch = branch;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public Pickup getPickup() {
		return pickup;
	}

	public void setPickup(Pickup pickup) {
		this.pickup = pickup;
	}

	public Branch getBranch() {
		return branch;
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
	}

	public Pickup getReservationID() {
		return pickup;
	}

	public void setReservationID(Pickup pickup) {
		this.pickup = pickup;
	}

	public Date getActualPickupDate() {
		return actualPickupDate;
	}

	public void setActualPickupDate(Date actualPickupDate) {
		this.actualPickupDate = actualPickupDate;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public User getEmployee() {
		return employee;
	}
	public void setEmployee(User employee) {
		this.employee = employee;
	}
	
}
