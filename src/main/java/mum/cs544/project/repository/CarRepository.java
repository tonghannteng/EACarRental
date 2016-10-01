package mum.cs544.project.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mum.cs544.project.domain.Car;

@Repository
public interface CarRepository extends CrudRepository<Car, Integer>{
	
	Car findByName(String CarName);
	
}
