package mum.cs544.project.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
public class CarHistory {
	@Id @GeneratedValue
	private int id;
	@ManyToOne
	@JoinColumn(name = "carId")
	private Car car;
	@Temporal(TemporalType.DATE)
	private Date date;
	@OneToOne
	@JoinColumn(name="employeeId")	
	private User employee;

	private ReportType reportType;
	private String report;
	
	public CarHistory() {

	}
	public CarHistory(Car car, Date date, User employee, ReportType reportType, String report) {
		super();
		this.car = car;
		this.date = date;
		this.employee = employee;
		this.reportType = reportType;
		this.report = report;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Car getCar() {
		return car;
	}
	public void setCar(Car car) {
		this.car = car;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public User getEmployee() {
		return employee;
	}
	public void setEmployee(User employee) {
		this.employee = employee;
	}

	@Enumerated(EnumType.STRING)
	public ReportType getReportType() {
		return reportType;
	}

	@Enumerated(EnumType.STRING)
	public void setReportType(ReportType reportType) {
		this.reportType = reportType;
	}
	public String getReport() {
		return report;
	}
	public void setReport(String report) {
		this.report = report;
	}
}
