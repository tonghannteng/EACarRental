package mum.cs544.project.domain;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Reservation {
	@Id
	@GeneratedValue
	private int id;
	@Temporal(TemporalType.TIMESTAMP)
	private Date pickupdate;
	private String pickuplocation;
	@Temporal(TemporalType.TIMESTAMP)
	public Date dropoffdate;
	@OneToOne(cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name = "carId")
	private Car car;
	public String dropofflocation;

	@OneToOne(mappedBy = "reservationID")
	private Pickup pickup;

	@OneToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	@JoinColumn(name = "clientId")
	private User client;
	
	public Reservation() {
		super();
	}

	public Reservation(Date pickupdate, String pickuplocation, Date dropoffdate, String dropofflocation, Car car,
			User client) {
		super();
		this.pickupdate = pickupdate;
		this.pickuplocation = pickuplocation;
		this.dropoffdate = dropoffdate;
		this.car = car;
		this.dropofflocation = dropofflocation;
		this.client = client;
	}

	public User getClient() {
		return client;
	}

	public void setClient(User client) {
		this.client = client;
	}

	public Pickup getPickup() {
		return pickup;
	}

	public void setPickup(Pickup pickup) {
		this.pickup = pickup;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public Date getPickupdate() {
		return pickupdate;
	}

	public void setPickupdate(Date pickupdate) {
		this.pickupdate = pickupdate;
	}
	public String getPickuplocation() {
		return pickuplocation;
	}
	public void setPickuplocation(String pickuplocation) {
		this.pickuplocation = pickuplocation;
	}

	public Date getDropoffdate() {
		return dropoffdate;
	}

	public void setDropoffdate(Date dropoffdate) {
		this.dropoffdate = dropoffdate;
	}
	public Car getCar() {
		return car;
	}
	public void setCar(Car car) {
		this.car = car;
	}
	public String getDropofflocation() {
		return dropofflocation;
	}
	public void setDropofflocation(String dropofflocation) {
		this.dropofflocation = dropofflocation;
	}

}
