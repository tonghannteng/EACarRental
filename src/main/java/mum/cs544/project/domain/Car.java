package mum.cs544.project.domain;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Car {
	// @Transient
	// private MultipartFile carImage;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	@JoinColumn(name = "carTypeId")
	@Valid
	@NotNull
	private CarType carType;

	@NotNull
	@Size(min = 1, max = 255, message = "name not null!")
	private String name;
	
	@NotNull
	@Size(min = 1, max = 255, message = "imageLink not null!")
	private String imageLink;
	
	@Min(value = 0)
	@NotNull
	private Integer numberOfMiles;
	@Min(value = 0)
	@NotNull
	private Integer pricePerDay;
	@Min(value = 2000)
	@NotNull
	private Integer year;
	@NotNull
	private Date lastInpsected;

	public Car() {
	}

	public Car(CarType carType, String name, String imageLink, Integer numberOfMiles, Integer pricePerDay, Integer year,
			Date lastInpsected) {
		super();
		this.carType = carType;
		this.name = name;
		this.imageLink = imageLink;
		this.numberOfMiles = numberOfMiles;
		this.pricePerDay = pricePerDay;
		this.year = year;
		this.lastInpsected = lastInpsected;
	}

	public String getImageLink() {
		return imageLink;
	}

	public void setImageLink(String imageLink) {
		this.imageLink = imageLink;
	}

	public Date getLastInpsected() {
		return lastInpsected;
	}

	public void setLastInpsected(Date lastInpsected) {
		this.lastInpsected = lastInpsected;
	}

	public CarType getCarType() {
		return carType;
	}

	public void setCarType(CarType carType) {
		this.carType = carType;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getNumberOfMiles() {
		return numberOfMiles;
	}

	public void setNumberOfMiles(Integer numberOfMiles) {
		this.numberOfMiles = numberOfMiles;
	}

	public Integer getPricePerDay() {
		return pricePerDay;
	}

	public void setPricePerDay(Integer pricePerDay) {
		this.pricePerDay = pricePerDay;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}
}
