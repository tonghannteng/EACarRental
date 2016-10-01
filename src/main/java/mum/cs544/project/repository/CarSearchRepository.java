package mum.cs544.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mum.cs544.project.domain.Branch;
import mum.cs544.project.domain.Car;

@Repository
public interface CarSearchRepository extends CrudRepository<Car, Integer> {

	@Query("SELECT C FROM Car C JOIN C.carType CT WHERE C NOT IN (SELECT C FROM Pickup P LEFT JOIN P.returncar RT  JOIN P.reservationID RE JOIN RE.car C WHERE RT.id IS NULL)  AND C NOT IN (SELECT C FROM Reservation RE LEFT JOIN RE.pickup P  JOIN RE.car C WHERE P.id IS NULL)")
	public List<Car> search();

	@Query("SELECT DISTINCT B FROM Branch B JOIN FETCH B.address WHERE B.id = ?1")
	public Branch atBranch(int carId);
}
