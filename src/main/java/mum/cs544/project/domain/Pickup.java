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
public class Pickup {
	@Id @GeneratedValue
	private int id;
	@OneToOne
	@JoinColumn(name="reservationId")
	private Reservation reservationID;
	@Temporal(TemporalType.TIMESTAMP)
	private Date actualPickupDate;
	@ManyToOne
	@JoinColumn(name="addressId")
	private Address address;
	@OneToOne
	@JoinColumn(name = "branchId")
	private Branch branch;
	@ManyToOne
	@JoinColumn(name="employeeId")
	private User employee;
	@OneToOne(mappedBy = "pickup")
	private ReturnCar returncar;

	public Pickup() {

	}

	public Pickup(Reservation reservationID, Date actualPickupDate, Address address, Branch branch, User employee) {
		super();
		this.reservationID = reservationID;
		this.actualPickupDate = actualPickupDate;
		this.address = address;
		this.branch = branch;
		this.employee = employee;
	}

	public Branch getBranch() {
		return branch;
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Reservation getReservationID() {
		return reservationID;
	}
	public void setReservationID(Reservation reservationID) {
		this.reservationID = reservationID;
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
