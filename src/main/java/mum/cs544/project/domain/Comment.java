package mum.cs544.project.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Comment {
	@Id
	@GeneratedValue
	private int id;
	@OneToOne
	@JoinColumn(name = "reservationId")
	private Reservation reservation;
	private String title;
	@Temporal(TemporalType.DATE)
	private Date date;
	private String userComment;


	private Rate rate;

	public String getComment() {
		return userComment;
	}

	public void setComment(String comment) {
		this.userComment = comment;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Comment() {
		super();
	}

	public int getId() {
		return id;
	}

	public Comment(Reservation reservation, String title, Date date, Rate rate) {
		super();
		this.reservation = reservation;
		this.title = title;
		this.date = date;
		this.rate = rate;
	}

	public Reservation getReservation() {
		return reservation;
	}

	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Enumerated(EnumType.STRING)
	public Rate getRate() {
		return rate;
	}

	@Enumerated(EnumType.STRING)
	public void setRate(Rate rate) {
		this.rate = rate;
	}

}
