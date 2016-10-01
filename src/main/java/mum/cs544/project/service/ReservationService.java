package mum.cs544.project.service;

import java.util.Date;
import java.util.List;

import mum.cs544.project.domain.Reservation;

public interface ReservationService {
	public Reservation save(Reservation reservation);

	public List<Reservation> findById(Integer id);

	public List<Reservation> getAll();

	void delete(Integer id);

	Reservation findById(int id);

	public void edit(Reservation reservation);

	public String reserve(String carId, String fromLocation, String toLocation, Date fromDate, Date toDate);
}
