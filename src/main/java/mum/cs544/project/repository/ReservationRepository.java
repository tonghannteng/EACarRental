package mum.cs544.project.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mum.cs544.project.domain.Car;
import mum.cs544.project.domain.Reservation;

@Repository
public interface ReservationRepository extends CrudRepository<Reservation, Integer> {
	Reservation findById(Integer id);

	@Query("SELECT C FROM Car C")
	public List<Car> search(String fromLocation, String toLocation, Date fromDate, Date toDate);
}
