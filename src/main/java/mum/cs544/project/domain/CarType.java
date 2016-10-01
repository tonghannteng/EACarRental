package mum.cs544.project.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CarType {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int numberOfCylinder;
	public int noOfPerson;
	public String carManufacturer;

	public CarType() {

	}

	public CarType(int numberOfCylinder, int noOfPerson, String carManufacturer) {
		super();
		this.numberOfCylinder = numberOfCylinder;
		this.noOfPerson = noOfPerson;
		this.carManufacturer = carManufacturer;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumberOfCylinder() {
		return numberOfCylinder;
	}

	public void setNumberOfCylinder(int numberOfCylinder) {
		this.numberOfCylinder = numberOfCylinder;
	}

	public int getNoOfPerson() {
		return noOfPerson;
	}

	public void setNoOfPerson(int noOfPerson) {
		this.noOfPerson = noOfPerson;
	}

	public String getCarManufacturer() {
		return carManufacturer;
	}

	public void setCarManufacturer(String carManufacturer) {
		this.carManufacturer = carManufacturer;
	}

}
